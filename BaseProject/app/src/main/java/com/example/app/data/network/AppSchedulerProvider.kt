package com.example.app.data.network

import com.example.common.data.network.SchedulerProvider
import io.reactivex.CompletableTransformer
import io.reactivex.MaybeTransformer
import io.reactivex.ObservableTransformer
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by jason on 02/10/2019.
 */
class AppSchedulerProvider @Inject constructor() : SchedulerProvider {
    override fun <T> getObservableScheduler(): ObservableTransformer<T, T> =
        ObservableTransformer { upstream ->
            upstream.subscribeOn(getIOThreadScheduler())
                .observeOn(getMainThreadScheduler())
        }

    override fun <T> ioToMainSingleScheduler(): SingleTransformer<T, T> =
        SingleTransformer { upstream ->
            upstream.subscribeOn(getIOThreadScheduler())
                .observeOn(getMainThreadScheduler())
        }

    override fun <T> ioToMainMaybeScheduler(): MaybeTransformer<T, T> =
        MaybeTransformer { upstream ->
            upstream.subscribeOn(getIOThreadScheduler())
                .observeOn(getMainThreadScheduler())
        }

    override fun ioToMainCompletableScheduler(): CompletableTransformer =
        CompletableTransformer { upstream ->
            upstream.subscribeOn(getIOThreadScheduler())
                .observeOn(getMainThreadScheduler())
        }

    private fun getIOThreadScheduler() = Schedulers.io()

    private fun getMainThreadScheduler() = AndroidSchedulers.mainThread()
}