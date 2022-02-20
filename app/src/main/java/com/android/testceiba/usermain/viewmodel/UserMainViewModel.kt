package com.android.testceiba.usermain.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.testceiba.api.UserRepository
import com.android.testceiba.usermain.model.User
import kotlinx.coroutines.Job

class UserMainViewModel(private val userRepository: UserRepository): ViewModel() {
    val getUserLiveData = MutableLiveData<List<User>>()

    fun getUsers() {

    }

}