package com.example.photos

import retrofit2.http.GET

interface PhotoApi {
    @GET ("photos")
    suspend fun getPhotos(): List<Photo>
}