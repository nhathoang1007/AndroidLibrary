package com.example.common.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.common.data.dao.UserDataDao
import com.example.common.model.UserData

/**
 * Created by jason on 04/10/2019.
 */
@Database(entities = [UserData::class], version = 1)
abstract class DatabaseManager : RoomDatabase() {
    companion object {
        const val DATABASE_NAME = "base_database"
    }

    abstract fun userDataDao(): UserDataDao
}