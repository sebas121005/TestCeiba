package com.android.testceiba.api

import com.android.testceiba.userdetail.model.Post
import com.android.testceiba.usermain.model.User
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET(API_USERS)
    suspend fun getUsers() : Response<List<User>>

    @GET(API_POST)
    suspend fun getPosts(@Query(USER_ID) userId: String): Response<List<Post>>

    companion object {
        const val API_USERS = "users/"
        const val API_POST = "posts/"
        const val USER_ID = "userId"
        const val URL = "https://jsonplaceholder.typicode.com/"
        
        var webService: WebService? = null
        fun getInstance() : WebService {
            if (webService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                webService = retrofit.create(WebService::class.java)
            }
            return webService!!
        }

    }
}