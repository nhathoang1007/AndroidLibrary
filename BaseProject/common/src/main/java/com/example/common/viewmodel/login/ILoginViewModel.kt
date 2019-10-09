package com.example.common.viewmodel.login

import com.example.common.viewmodel.base.IViewModel

/**
 * Created by jason on 02/10/2019.
 */
interface ILoginViewModel : IViewModel {
    fun login(email: String, password: String)
}