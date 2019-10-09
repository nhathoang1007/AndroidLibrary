package com.example.common.data.network

import io.reactivex.CompletableTransformer
import io.reactivex.MaybeTransformer
import io.reactivex.ObservableTransformer
import io.reactivex.SingleTransformer

/**
 * Created by jason on 02/10/2019.
 */
interface SchedulerProvider {
    fun <T> getObservableScheduler(): ObservableTransformer<T, T>
    fun <T> ioToMainSingleScheduler(): SingleTransformer<T, T>
    fun <T> ioToMainMaybeScheduler(): MaybeTransformer<T, T>
    fun ioToMainCompletableScheduler(): CompletableTransformer
}