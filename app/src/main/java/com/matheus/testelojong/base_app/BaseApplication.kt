package com.matheus.testelojong.base_app

import android.app.Application
import com.matheus.testelojong.common.di.commonModule
import com.matheus.testelojong.feature.home.di.homeModule
import com.matheus.testelojong.feature.meditation_board.di.meditationBoardModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                homeModule +
                        commonModule +
                        meditationBoardModule
            ).androidContext(applicationContext)
        }
    }
}