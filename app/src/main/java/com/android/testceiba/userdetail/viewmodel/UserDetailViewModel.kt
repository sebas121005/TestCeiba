package com.android.testceiba.userdetail.viewmodel

import androidx.lifecycle.ViewModel
import com.android.testceiba.api.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserDetailViewModel: ViewModel() {

    var mUserRepository: UserRepository? = null

    fun getPosts() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = mUserRepository?.getPost()
            if (response?.isSuccessful!!) {
                
            }
        }
    }
}