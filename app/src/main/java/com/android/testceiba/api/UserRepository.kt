package com.android.testceiba.api

class UserRepository(private val webService: WebService) {
    var userId: String? = null
    suspend fun getUsers() = webService.getUsers()
    suspend fun getPost() = webService.getPosts(userId!!)
}