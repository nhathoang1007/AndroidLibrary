package com.example.common.data

import android.content.Context
import androidx.room.Room
import com.example.common.data.database.DatabaseImpl
import com.example.common.data.database.DatabaseManager
import com.example.common.data.database.IDatabaseHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by jason on 04/10/2019.
 */
@Module
class DataModule {

    @Singleton
    @Provides
    fun providerDatabaseManager(context: Context): DatabaseManager {
        return Room.databaseBuilder(
            context, DatabaseManager::class.java,
            DatabaseManager.DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun providerDatabaseHelper(manager: DatabaseManager): IDatabaseHelper {
        return DatabaseImpl(manager)
    }
}