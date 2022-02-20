package com.android.testceiba.usermain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class User(@SerializedName("id") var id: Int,
                @SerializedName("name") var name: String,
                @SerializedName("phone") var phone: String,
                @SerializedName("email") var email: String)

@Entity
data class UserDB(@PrimaryKey var id: Int,
                  var name: String,
                  var phone: String,
                  var email: String)
