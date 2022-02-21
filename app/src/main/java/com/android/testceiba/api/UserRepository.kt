package com.android.testceiba.api

class UserRepository(private val webService: WebService) {
    suspend fun getUsers() = webService.getUsers()
    suspend fun getPost(userId: String) = webService.getPosts(userId)
}