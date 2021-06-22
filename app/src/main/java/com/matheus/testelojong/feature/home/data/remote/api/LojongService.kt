package com.matheus.testelojong.feature.home.data.remote.api

import com.matheus.testelojong.feature.home.data.remote.model.FactsResponse
import retrofit2.Call
import retrofit2.http.GET

interface LojongService {

    @GET("facts")
    fun getFacts(): Call<List<FactsResponse>>
}