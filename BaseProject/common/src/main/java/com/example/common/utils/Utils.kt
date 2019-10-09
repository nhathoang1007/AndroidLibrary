package com.example.common.utils

import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Created by Jason on 3/10/2019.
 */
class Utils {

    companion object {
        fun isNetworkError(throwable: Throwable): Boolean {
            return throwable is SocketTimeoutException || throwable is UnknownHostException
        }
    }
}