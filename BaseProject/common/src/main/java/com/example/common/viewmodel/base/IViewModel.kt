package com.example.common.viewmodel.base

import androidx.lifecycle.MutableLiveData
import com.example.common.model.error.ErrorMessage

/**
 * Created by jason on 02/10/2019.
 */
interface IViewModel {

    var isLoading: MutableLiveData<Boolean>
    var error: MutableLiveData<ErrorMessage>

    fun onCreate()
    fun onStart()
    fun onPause()
    fun onResume()
    fun onStop()
    fun onDestroy()
}