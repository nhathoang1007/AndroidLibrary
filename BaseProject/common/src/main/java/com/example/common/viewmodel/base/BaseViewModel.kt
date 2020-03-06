package com.example.common.viewmodel.base

import android.util.Log
import androidx.lifecycle.*
import com.example.common.model.error.ErrorMessage
import com.example.common.repository.base.BaseRepository
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by jason on 02/10/2019.
 */
abstract class BaseViewModel protected constructor(repository: BaseRepository) : ViewModel(),
    IViewModel, LifecycleObserver {

    var disposable = CompositeDisposable()

    override var isLoading: MutableLiveData<Boolean> = MutableLiveData()

    override var error: MutableLiveData<ErrorMessage> = MutableLiveData()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    override fun onCreate() {
        Log.e("ViewModel_Lifecycle", "onCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    override fun onStart() {
        Log.e("ViewModel_Lifecycle", "onStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    override fun onResume() {
        Log.e("ViewModel_Lifecycle", "onResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    override fun onPause() {
        Log.e("ViewModel_Lifecycle", "onPause")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    override fun onStop() {
        Log.e("ViewModel_Lifecycle", "onStop")
        disposable.clear()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun onDestroy() {
        Log.e("ViewModel_Lifecycle", "onDestroy")
        if (!disposable.isDisposed) disposable.dispose()
    }
}