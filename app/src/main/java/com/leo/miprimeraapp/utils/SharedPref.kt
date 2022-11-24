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

    fun save(key: String, value: String) { // "user": {"user": "admin", "email": "lperez"}
        try {
            with(prefs?.edit()) {
                this?.putString(key, value)
                this?.commit()
            }
        } catch (e: Exception) {
            Log.d("Error", "Err ${e.message}")
        }
    }

    // Todo: Obtener la session
    fun getData(key: String): String? {
        return prefs?.getString(key, "") // "user"
    }

    //Todo: Remover la session
    fun remove(key: String) {
        prefs?.edit()?.remove(key)?.apply()
    }
}