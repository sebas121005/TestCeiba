package com.androidnexos.testceiba.api

import retrofit2.Response
import retrofit2.http.GET

interface WebService {
    @GET("users/")
    suspend fun getAllMovies() : Response<List<User>>
}