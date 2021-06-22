package com.matheus.testelojong.feature.home.di

import com.matheus.testelojong.feature.home.presetantion.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homePresentationModule = module {
    viewModel {
        HomeViewModel(
            sharedPreferencesHelperHome = get(),
            factsDataSource = get()
        )
    }
}