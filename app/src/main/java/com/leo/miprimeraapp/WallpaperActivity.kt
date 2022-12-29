package com.leo.miprimeraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.leo.miprimeraapp.adapters.ImageAdapter
import com.leo.miprimeraapp.api.APIService
import com.leo.miprimeraapp.databinding.ActivityWallpaperBinding
import com.leo.miprimeraapp.models.Hit
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WallpaperActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWallpaperBinding
    private lateinit var adapter: ImageAdapter
    private val photoImages = mutableListOf<Hit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWallpaperBinding.inflate(layoutInflater)
        binding.txtSearch.addTextChangedListener { query ->
            searchByName(query.toString())
        }
        setContentView(binding.root)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = ImageAdapter(photoImages)
        binding.imagesRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.imagesRecyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.imagesRecyclerView.adapter = adapter
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pixabay.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun searchByName(query: String) {
        val apikey = "17877279-9919024b9909b09353f277b8f"
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).listPhotos(apikey, query, "all")
            val result = call.body()
            runOnUiThread {
                //si hay contenido adentro
                if (call.isSuccessful) {
                    // mostrar las images en el recyclerview
                    val images = result?.hits ?: emptyList()
                    photoImages.clear()
                    photoImages.addAll(images)
                    adapter.notifyDataSetChanged()
                } else {
                    // mostrar error
                    showError()
                }
            }
        }
    }

    private fun showError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
    }
}