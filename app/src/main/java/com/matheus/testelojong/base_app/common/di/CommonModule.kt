package com.matheus.testelojong.base_app.common.di

import com.matheus.testelojong.base_app.common.ThreadContextProvider
import com.matheus.testelojong.base_app.common.data.local.SharedPreferencesHelper
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val commonModule = module {

    single {
        ThreadContextProvider()
    }

    single {
        SharedPreferencesHelper(androidApplication())
    }
}