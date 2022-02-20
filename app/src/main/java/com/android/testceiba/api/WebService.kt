package com.android.testceiba.api

import com.android.testceiba.userdetail.model.Post
import com.android.testceiba.usermain.model.User
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("users/")
    suspend fun getUsers() : Response<List<User>>

    @GET("posts/")
    suspend fun getPosts(@Query("userId") userId: String): Response<List<Post>>

    companion object {
        var webService: WebService? = null
        fun getInstance() : WebService {
            if (webService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                webService = retrofit.create(WebService::class.java)
            }
            return webService!!
        }

    }
}