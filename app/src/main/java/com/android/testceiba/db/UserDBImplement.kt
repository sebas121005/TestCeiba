package com.android.testceiba.db

import androidx.room.Database
import com.android.testceiba.usermain.model.UserDB

@Database(
    entities = [UserDB::class],
    version = 1
)
abstract class UserDBImplement {
    abstract fun userDao(): UserDao
}