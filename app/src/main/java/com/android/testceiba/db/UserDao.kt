package com.android.testceiba.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.android.testceiba.usermain.model.User

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(listUsers: List<User>)

    @Query("SELECT id FROM UserDB")
    suspend fun findUserId(): Int
}