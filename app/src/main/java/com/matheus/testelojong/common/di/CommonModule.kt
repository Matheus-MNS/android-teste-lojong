package com.matheus.testelojong.common.di

import com.matheus.testelojong.common.data.local.SharedPreferencesHelper
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val commonModule = module {

    single {
        SharedPreferencesHelper(androidApplication())
    }
}