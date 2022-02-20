package com.android.testceiba.userdetail.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.testceiba.api.UserRepository
import com.android.testceiba.userdetail.model.Post
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserDetailViewModel: ViewModel() {

    var mUserRepository: UserRepository? = null

    var getPostLiveData = MutableLiveData<List<Post>>()

    val showLoadingLiveData = MutableLiveData<Boolean>()

    fun getPosts(userId: String) {
        CoroutineScope(Dispatchers.IO).launch {
            mUserRepository?.userId = userId
            val response = mUserRepository?.getPost()
            if (response?.isSuccessful!!) {
                withContext(Dispatchers.Main) {
                    response.body()?.let {
                        getPostLiveData.value = it
                        showLoadingLiveData.value = false
                    }
                }
            }
        }
    }
}