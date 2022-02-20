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
    val showLoadingLiveData = MutableLiveData<Boolean>()

    var mUserRepository: UserRepository? = null
    var mRoomImpl: UserDBImplement? = null

    fun getUsers() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = mUserRepository?.getUsers()
            if (response?.isSuccessful!!) {
                response.body()?.let {
                    insertUsers(it)

                    withContext(Dispatchers.Main) {
                        getUserLiveData.value = it
                        showLoadingLiveData.value = false
                    }
                }
            }
        }
    }

    private suspend fun insertUsers(listUsers: List<User>) {

        var userDB: UserDB
        for (i in listUsers.indices) {
            val dataUserId = mRoomImpl?.userDao()?.findUserId(listUsers[i].id)
            if (dataUserId?.size != 0) {
                continue
            } else {
                userDB = UserDB(listUsers[i].id, listUsers[i].name, listUsers[i].phone, listUsers[i].email)
                mRoomImpl?.userDao()?.insertUser(userDB)
            }
        }
    }

}