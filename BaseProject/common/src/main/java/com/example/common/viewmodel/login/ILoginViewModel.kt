package com.example.common.viewmodel.login

import androidx.lifecycle.LiveData
import com.example.common.viewmodel.base.IViewModel

/**
 * Created by jason on 02/10/2019.
 */
interface ILoginViewModel : IViewModel {
    val isLoginSuccess: LiveData<Boolean>
    fun login(email: String, password: String)
}