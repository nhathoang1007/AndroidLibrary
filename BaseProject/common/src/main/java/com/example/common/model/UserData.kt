package com.example.common.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by jason on 02/10/2019.
 */
@Entity(tableName = "UserData")
class UserData(

    @PrimaryKey
    @Expose
    val id: String,

    @SerializedName("user_name")
    @Expose
    val name: String,

    @SerializedName("email")
    @Expose
    val email: String,

    @SerializedName("phone")
    @Expose
    val phone: String
)