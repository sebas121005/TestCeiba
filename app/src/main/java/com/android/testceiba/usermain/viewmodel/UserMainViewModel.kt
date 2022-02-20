package com.android.testceiba.usermain.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.testceiba.api.UserRepository
import com.android.testceiba.usermain.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserMainViewModel: ViewModel() {
    val getUserLiveData = MutableLiveData<List<User>>()
    var userRepository: UserRepository? = null

    fun getUsers() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = userRepository?.getUsers()
            withContext(Dispatchers.Main) {
                if (response?.isSuccessful!!) {
                    Log.e("USERS", response.body().toString())
                }
            }
        }
    }

    fun insertUsers() {
        
    }

}