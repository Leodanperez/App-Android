package com.leo.miprimeraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts.*

class GaleryActivity : AppCompatActivity() {

    val pickMedia = registerForActivityResult(PickVisualMedia()) { uri ->
        if (uri != null) {
            //Imagen Seleccionada
            imgView.setImageURI(uri)
        } else {
            // no imagen
        }
    }

    lateinit var btnImage: Button
    lateinit var imgView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_galery)
        btnImage = findViewById(R.id.btnImage)
        imgView = findViewById(R.id.viewImage)
        btnImage.setOnClickListener {
            pickMedia.launch(PickVisualMediaRequest(PickVisualMedia.ImageOnly))
        }
    }
}