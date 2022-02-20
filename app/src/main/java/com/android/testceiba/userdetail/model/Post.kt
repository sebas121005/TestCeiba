package com.android.testceiba.userdetail.model

import com.google.gson.annotations.SerializedName

data class Post(@SerializedName("title") var postTitle: String,
                @SerializedName("body") var postBody: String)
