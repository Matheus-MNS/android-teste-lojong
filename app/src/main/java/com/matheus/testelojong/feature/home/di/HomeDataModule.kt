package com.matheus.testelojong.feature.home.di

import com.matheus.testelojong.feature.home.data.local.SharedPreferencesHelperHome
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val homeDataModule = module {

    single { SharedPreferencesHelperHome(androidApplication()) }
}