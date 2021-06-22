package com.matheus.testelojong.feature.home.di

import com.matheus.testelojong.base_app.common.network.BASE_URL
import com.matheus.testelojong.base_app.common.network.WebServiceFactory
import com.matheus.testelojong.feature.home.data.local.SharedPreferencesHelperHome
import com.matheus.testelojong.feature.home.data.remote.FactsDataSource
import com.matheus.testelojong.feature.home.data.remote.api.LojongService
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val homeDataModule = module {

    single {
        WebServiceFactory.getRetrofitInstance(BASE_URL) as LojongService
    }

    single { SharedPreferencesHelperHome(androidApplication()) }

    factory {
        FactsDataSource(
            lojongService = get()
        )
    }
}