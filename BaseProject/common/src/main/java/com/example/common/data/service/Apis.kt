package com.example.common.data.service

import android.service.autofill.UserData
import com.google.gson.JsonObject
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by jason on 02/10/2019.
 */
interface Apis {

    @POST("ninja/login")
    fun login(@Body jsonObject: JsonObject): Observable<String>
}