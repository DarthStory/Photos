package com.example.photos

import com.google.gson.annotations.SerializedName

data class Photo(
    val id: String,
    @SerializedName("img_src")
    val imgSrc: String
)
