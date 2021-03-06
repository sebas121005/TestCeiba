package com.android.testceiba.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.android.testceiba.usermain.model.UserDB

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(usersDB: UserDB)

    @Query("SELECT * FROM UserDB WHERE id = :id")
    suspend fun findUserId(id: Int): List<UserDB>
}