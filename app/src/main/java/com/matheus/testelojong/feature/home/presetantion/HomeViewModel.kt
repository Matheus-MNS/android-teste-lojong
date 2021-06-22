package com.matheus.testelojong.feature.home.presetantion

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.matheus.testelojong.feature.home.data.local.SharedPreferencesHelperHome
import com.matheus.testelojong.feature.home.data.remote.FactsDataSource
import com.matheus.testelojong.feature.home.data.remote.mapper.FactsMapper
import com.matheus.testelojong.feature.home.data.remote.model.FactsResponse
import com.matheus.testelojong.feature.home.domain.model.FactsModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel(
    private val sharedPreferencesHelperHome: SharedPreferencesHelperHome,
    private val factsDataSource: FactsDataSource
) : ViewModel() {

    val factsList: MutableLiveData<List<FactsModel>> by lazy {
        MutableLiveData<List<FactsModel>>()
    }

    init {
        getFacts()
    }

    private fun getFacts() {
        val callback = factsDataSource.getFacts()
        callback.enqueue(object : Callback<List<FactsResponse>> {
            override fun onFailure(call: Call<List<FactsResponse>>, t: Throwable) {
                factsList.value = emptyList()
            }

            override fun onResponse(
                call: Call<List<FactsResponse>>,
                response: Response<List<FactsResponse>>
            ) {
                factsList.value = FactsMapper.toDomain(response.body())
                //salvar no sharedPreferences
            }
        })
    }
}