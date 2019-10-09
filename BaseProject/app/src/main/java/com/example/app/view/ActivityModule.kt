package com.example.app.view

import com.ecoatm.ecoapp.android.dagger.scope.ActivityScope
import com.example.app.view.login.LoginActivity
import com.example.common.viewmodel.login.LoginModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by jason on 02/10/2019.
 */
@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [LoginModule::class])
    abstract fun providerLoginActivity(): LoginActivity
}