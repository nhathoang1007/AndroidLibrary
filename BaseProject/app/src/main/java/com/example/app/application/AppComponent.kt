package com.example.app.application

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton

/**
 * Created by jason on 01/10/2019.
 */
@Component(modules = [AppModule::class])
@Singleton
interface AppComponent : AndroidInjector<DaggerApplication> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent

    }

    fun inject(app: MyApplication)

    override fun inject(instance: DaggerApplication)
}