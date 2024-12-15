package com.example.photos

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    val api: PhotoApi by lazy {
        retrofit.create(PhotoApi::class.java)
    }

}