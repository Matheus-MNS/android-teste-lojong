package com.matheus.testelojong.feature.home.data.remote

import com.matheus.testelojong.feature.home.data.remote.api.LojongService

class FactsRemoteDataSource(private val lojongService: LojongService) {
    fun getFacts() = lojongService.getFacts()
}



