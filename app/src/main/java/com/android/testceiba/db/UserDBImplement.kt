package com.android.testceiba.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.testceiba.usermain.model.UserDB

@Database(
    entities = [UserDB::class],
    version = 1
)
abstract class UserDBImplement: RoomDatabase() {
    abstract fun userDao(): UserDao
}