package com.example.common.data.service

import android.service.autofill.UserData
import com.google.gson.JsonObject
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by jason on 02/10/2019.
 */
class RestApiHelper @Inject constructor(private val retrofit: Retrofit) {
    private val service: Apis
        get() = retrofit.create(Apis::class.java)

    fun login(body: JsonObject): Observable<String> {
        return service.login(body)
    }
}