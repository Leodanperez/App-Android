package com.leo.miprimeraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.leo.miprimeraapp.databinding.ActivityWallpaperBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WallpaperActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWallpaperBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWallpaperBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pixabay.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}