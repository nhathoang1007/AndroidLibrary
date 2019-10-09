package com.example.app.application

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Created by jason on 01/10/2019.
 */
class MyApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent.builder().application(this).build()
        appComponent.inject(this)
        return appComponent
    }
}