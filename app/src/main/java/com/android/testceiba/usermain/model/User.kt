package com.android.testceiba.usermain.model

import com.google.gson.annotations.SerializedName

data class User(@SerializedName("name") var name: String,
                @SerializedName("phone") var phone: String,
                @SerializedName("email") var email: String)
