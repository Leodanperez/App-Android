package com.leo.miprimeraapp.utils

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.util.Log

class SharedPref (activity: Activity) {
    private var prefs: SharedPreferences? = null

    init {
        prefs = activity.getSharedPreferences("com.leo.miprimeraapp", Context.MODE_PRIVATE)
    }

    fun save(key: String, obj: Any) {
        try {
            val gson = null
            // todo add gson
            // todo add json
            with(prefs?.edit()) {
                this?.putString(key, gson)
                this?.commit()
            }
        } catch (e: Exception) {
            Log.d("Error", "Err ${e.message}")
        }
    }
}