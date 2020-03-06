package com.example.common.data.network

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by jason on 01/10/2019.
 */
@Module
class NetworkModule {

    companion object {

        private const val CACHE_SIZE = 10 * 1024 * 1024
        private const val CONNECT_TIMEOUT = 180 // ms
        private const val READ_TIMEOUT = 180 // ms
        private const val WRITE_TIMEOUT = 180 // ms
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(context: Context): OkHttpClient =
        OkHttpClient().newBuilder()
            .cache(Cache(context.cacheDir, CACHE_SIZE.toLong()))
            .addInterceptor {
                val request = it.request()
                val builder = request.newBuilder()
                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
                it.proceed(builder.build())

            }
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .connectTimeout(CONNECT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()

    @Provides
    @Singleton
    fun provideRestAdapter(client: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://52.221.204.195/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()
    }
}