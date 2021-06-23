package com.matheus.testelojong.base_app.common.data.local

import android.content.Context
import com.google.gson.GsonBuilder
import com.matheus.testelojong.feature.home.domain.model.FactsModel

const val SHARED_PREFERENCES = "sharedPreferences"

class SharedPreferencesHelper(private val context: Context) {

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)

    fun saveString(key: String, value: String?) = sharedPreferences.edit().run {
        putString(key,value )
        apply()
    }

    fun getString(key: String) = sharedPreferences.run {
        getString(key,"")
    }
}



