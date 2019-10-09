package com.example.common.viewmodel.login

import androidx.annotation.NonNull
import dagger.Binds
import dagger.Module

/**
 * Created by jason on 02/10/2019.
 */
@Module
abstract class LoginModule {

    @Binds
    abstract fun providerViewModel(model: LoginViewModel): ILoginViewModel

}