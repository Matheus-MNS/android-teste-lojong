
package com.matheus.testelojong.base_app.common.di

import com.matheus.testelojong.base_app.common.ThreadContextProvider
import org.koin.dsl.module

val commonModule = module {
    single {
        ThreadContextProvider()
    }
}