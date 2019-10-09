package com.example.common.repository.base

import androidx.lifecycle.MutableLiveData
import com.example.common.model.error.ErrorMessage

/**
 * Created by jason on 02/10/2019.
 */
abstract class BaseRepository protected constructor() {

    private var error: MutableLiveData<ErrorMessage>? = MutableLiveData()
    private var isLoading: MutableLiveData<Boolean> = MutableLiveData()

    init {
        isLoading.value = false
    }

    fun getError(): MutableLiveData<ErrorMessage> {
        return error!!
    }

    fun setError(errorMessage: ErrorMessage) {
        this.error!!.value = errorMessage
    }

    fun isLoading(): MutableLiveData<Boolean> {
        return isLoading
    }

    fun setLoading(isLoading: Boolean) {
        this.isLoading.value = isLoading
    }
}