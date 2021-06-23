package com.matheus.testelojong.feature.home.data.local

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.matheus.testelojong.base_app.common.data.local.SharedPreferencesHelper
import com.matheus.testelojong.feature.home.domain.model.FactsModel

const val FACTS_LIST = "factsList"

class FactsLocalDataSource(
    private val sharedPreferencesHelper: SharedPreferencesHelper
) {
    fun saveFactsList(factsList: List<FactsModel>) {
        sharedPreferencesHelper.saveString(
            FACTS_LIST,
            GsonBuilder().create().toJson(factsList)
        )
    }

    fun getFactsList(): List<FactsModel>? {
        val value = sharedPreferencesHelper.getString(FACTS_LIST)
        return if (value.isNullOrEmpty()) {
            null
        } else {
            // val type = TypeToken<List<FactsModel?>?>().type
            val type = object : TypeToken<List<FactsModel?>?>() {}.type
            Gson().fromJson(value, type)
        }
    }
}