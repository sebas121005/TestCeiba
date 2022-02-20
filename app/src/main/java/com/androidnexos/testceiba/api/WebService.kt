package com.androidnexos.testceiba.api

import com.androidnexos.testceiba.usermain.model.User
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface WebService {
    @GET("users/")
    suspend fun getUsers() : Response<List<User>>

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