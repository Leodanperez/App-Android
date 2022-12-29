package com.leo.miprimeraapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import com.leo.miprimeraapp.databinding.ActivityMainBinding
import com.leo.miprimeraapp.utils.SharedPref

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getUserFromSession()

        binding.btnLogin.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val username = binding.txtUsername.editText?.text.toString()
        val password = binding.txtPassword.editText?.text.toString()

        if (username == "admin" && password == "12345") {
            saveUserInSession(username)
        } else {
            Toast.makeText(this, "Usuario incorrecto", Toast.LENGTH_LONG).show()
        }
        //Toast.makeText(this, "$username, $password", Toast.LENGTH_LONG).show()

    }

    private fun saveUserInSession(user: String) {
        val sharedPref = SharedPref(this)
        sharedPref.save("user", user)

        if (!sharedPref.getData("user").isNullOrBlank()) {
            goToSecondActivity()
        } else {
            Toast.makeText(this, "No hay data", Toast.LENGTH_LONG).show()
        }
    }

    private fun goToSecondActivity() {
        //val i = Intent(this, GaleryActivity::class.java)
        val i = Intent(this, WallpaperActivity::class.java)
        i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(i)
    }

    private fun getUserFromSession() {
        val sharedPref = SharedPref(this)
        if (!sharedPref.getData("user").isNullOrBlank()) {
            goToSecondActivity()
        } else {
            Toast.makeText(this, "Session Caducada", Toast.LENGTH_LONG).show()
        }
    }
}