package com.matheus.testelojong.base_app.common

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.lang.Exception

abstract class UseCase<T, in Params>(private val scope: CoroutineScope) : KoinComponent {

    private val contextProvider: ThreadContextProvider by inject()

    abstract fun run(params: Params? = null): Flow<T>

    operator fun invoke(
        params: Params? = null,
        onSuccess: (T) -> Unit = {},
        onError: ((Throwable) -> Unit) = {}
    ) {
        scope.launch(contextProvider.io) {
            try {
                run(params).collect {
                    withContext(contextProvider.main) {
                        onSuccess(it)
                    }
                }
            } catch (e: Exception) {
                withContext(contextProvider.main) {
                    onError(e)
                }
            }
        }
    }

    fun cancel() = scope.coroutineContext.cancelChildren()
}