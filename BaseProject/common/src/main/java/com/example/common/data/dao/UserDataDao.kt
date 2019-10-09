package com.example.common.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.common.model.UserData
import io.reactivex.Maybe

/**
 * Created by jason on 04/10/2019.
 */
@Dao
abstract class UserDataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(data: UserData)
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    abstract fun insert(data: List<UserData>)

    @Query("SELECT * FROM UserData WHERE id = :id")
    abstract fun get(id: String): Maybe<UserData>

    @Query("SELECT * FROM UserData")
    abstract fun get(): Maybe<List<UserData>>

    @Query("DELETE FROM UserData")
    abstract fun delete()
}