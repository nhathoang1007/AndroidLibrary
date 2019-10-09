package com.example.common.data.database

import com.example.common.data.dao.UserDataDao

/**
 * Created by jason on 04/10/2019.
 */
interface IDatabaseHelper {
    fun userDataDao(): UserDataDao
}