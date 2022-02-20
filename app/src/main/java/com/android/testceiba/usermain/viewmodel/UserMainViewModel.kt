package com.android.testceiba.usermain.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.testceiba.api.UserRepository
import com.android.testceiba.db.UserDBImplement
import com.android.testceiba.usermain.model.User
import com.android.testceiba.usermain.model.UserDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserMainViewModel: ViewModel() {
    val getUserLiveData = MutableLiveData<List<User>>()

    var mUserRepository: UserRepository? = null
    var mRoomImpl: UserDBImplement? = null

    fun getUsers() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = mUserRepository?.getUsers()
            if (response?.isSuccessful!!) {
                Log.e("USERS", response.body().toString())
                withContext(Dispatchers.Main) {

                }
            }
        }
    }

    suspend fun insertUsers(users: UserDB) {
        mRoomImpl?.userDao()?.insertUser(users)
    }

}