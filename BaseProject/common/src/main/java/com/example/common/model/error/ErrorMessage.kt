package com.example.common.model.error

import org.json.JSONObject
import retrofit2.Response
import java.net.UnknownHostException

/**
 * Created by jason on 02/10/2019.
 */
class ErrorMessage {

    private var error: CommonError = CommonError.UNKNOWN
    private var message: String = ""

    fun setResponseError(response: Response<*>) {
        setError(response.code())
        try {
            val jObjError = JSONObject(response.errorBody()!!.string())
            message = jObjError.getString("message")
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun onApiFailure(error: Throwable) {
        if (error is UnknownError || error is UnknownHostException) {
            setError(NETWORK_ERROR)
        } else {
            setError(SERVER_ERROR)
        }
    }

    private fun setError(code: Int) {
        when (code) {
            NETWORK_ERROR -> error = CommonError.NETWORK_ERROR
            TOKEN_EXPIRED -> error = CommonError.UNAUTHENTICATED
            BAD_REQUEST -> error = CommonError.BAD_REQUEST
            SERVER_ERROR -> error = CommonError.SERVER_ERROR
            RESULT_ERROR -> error = CommonError.RESULT_ERROR
        }
    }

    companion object {
        const val TOKEN_EXPIRED = 401
        const val BAD_REQUEST = 400
        const val SERVER_ERROR = 500
        const val RESULT_ERROR = 404
        const val NETWORK_ERROR = 1
    }
}