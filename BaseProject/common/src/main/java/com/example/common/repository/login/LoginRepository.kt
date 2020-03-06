package com.example.common.repository.login

import com.example.common.data.database.DatabaseImpl
import com.example.common.data.service.RestApiHelper
import com.example.common.model.UserData
import com.example.common.repository.base.BaseRepository
import com.google.gson.JsonObject
import io.reactivex.Maybe
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by jason on 02/10/2019.
 */
class LoginRepository @Inject constructor(
    private val restApiHelper: RestApiHelper
) :
    BaseRepository() {
    fun login(email: String, password: String): Observable<String> {
        val body = JsonObject()
        body.addProperty("email", email)
        body.addProperty("password", password)
        return restApiHelper.login(body)
    }
}