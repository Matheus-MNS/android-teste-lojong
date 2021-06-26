package com.matheus.testelojong.feature.home.presetantion

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.matheus.testelojong.feature.home.data.local.FactsLocalDataSource
import com.matheus.testelojong.feature.home.data.remote.FactsRemoteDataSource
import com.matheus.testelojong.feature.home.data.remote.mapper.FactsMapper
import com.matheus.testelojong.feature.home.data.remote.model.FactsResponse
import com.matheus.testelojong.feature.home.data.model.FactsModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel(
    private val factsRemoteDataSource: FactsRemoteDataSource,
    private val factsLocalDataSource: FactsLocalDataSource
) : ViewModel() {

    var factsList = factsLocalDataSource.getFactsList()

    //First = isLocalList - Second = isRequestSuccess
    val factsListStates: MutableLiveData<Pair<Boolean, Boolean>> by lazy {
        MutableLiveData<Pair<Boolean, Boolean>>()
    }

    init {
        getFactsList()
    }


    private fun getFactsList() {
        if (factsList.isNullOrEmpty()) {
            getFactsListRemotely()
        } else {
            factsListStates.value = Pair(first = true, second = false)
        }
    }

    private fun getFactsListRemotely() {
        val callback = factsRemoteDataSource.getFacts()
        callback.enqueue(object : Callback<List<FactsResponse>> {
            override fun onFailure(call: Call<List<FactsResponse>>, t: Throwable) {
                factsListStates.value = Pair(first = false, second = false)
            }

            override fun onResponse(
                call: Call<List<FactsResponse>>,
                response: Response<List<FactsResponse>>
            ) {
                factsList = FactsMapper.toDomain(response.body())
                factsListStates.value = Pair(first = false, second = true)
                saveFactsListLocally(factsList)
            }
        })
    }

    private fun saveFactsListLocally(factsList: List<FactsModel>?) {
        if (!factsList.isNullOrEmpty()) {
            factsLocalDataSource.saveFactsList(factsList)
        }
    }
}

