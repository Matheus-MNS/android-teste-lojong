package com.matheus.testelojong.feature.home.data.local

import android.content.Context
import com.google.gson.GsonBuilder
import com.matheus.testelojong.feature.home.domain.model.FactsModel

const val FACTS_FILE = "factsFile"

class SharedPreferencesHelperHome(private val context: Context) {

    private val sharedPreferences =
        context.getSharedPreferences(FACTS_FILE, Context.MODE_PRIVATE)

    fun saveFactsOnPreferences(objects: List<FactsModel>, key: String) = sharedPreferences.edit().run {
        val jSonString = GsonBuilder().create().toJson(objects)
        putString(key, jSonString)
        apply()
    }

    fun getFactsFromPreferences(key: String): List<FactsModel> {
        val value = sharedPreferences.getString(key, null)
        return listOf(GsonBuilder().create().fromJson(value, FactsModel::class.java))
    }
}

