package com.matheus.testelojong.feature.home.data.remote

import com.matheus.testelojong.feature.home.data.remote.api.LojongService

class FactsDataSource(
    private val lojongService: LojongService
) {
    fun getFacts() = lojongService.getFacts()
}



