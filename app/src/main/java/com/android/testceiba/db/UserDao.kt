package com.android.testceiba.db

import androidx.room.Insert
import com.android.testceiba.usermain.model.User

interface UserDao {
    @Insert
    suspend fun insertUser(listUsers: List<User>)
}