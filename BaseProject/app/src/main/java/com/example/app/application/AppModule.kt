package com.example.app.application

import android.app.Application
import android.content.Context
import com.example.app.data.network.AppSchedulerProvider
import com.example.app.view.ActivityModule
import com.example.common.data.DataModule
import com.example.common.data.network.NetworkModule
import com.example.common.data.network.SchedulerProvider
import dagger.Binds
import dagger.Module
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by jason on 01/10/2019.
 */
@Module(
    includes = [
        AndroidSupportInjectionModule::class,
        NetworkModule::class,
        ActivityModule::class,
        DataModule::class
    ]
)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideContext(application: Application): Context

    @Binds
    @Singleton
    abstract fun provideScheduler(provider: AppSchedulerProvider): SchedulerProvider
}