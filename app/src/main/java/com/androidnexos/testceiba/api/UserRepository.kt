package com.androidnexos.testceiba.api

class UserRepository(private val webService: WebService) {
    suspend fun getUsers() = webService.getUsers()
}