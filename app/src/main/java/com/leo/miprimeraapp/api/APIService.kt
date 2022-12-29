package com.leo.miprimeraapp.api

import com.leo.miprimeraapp.models.PhotoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    //https://pixabay.com/api/?key=17877279-9919024b9909b09353f277b8f&q=yellow+flowers&image_type=photo
    @GET("?")
    suspend fun listPhotos(
        @Query("key") apikey: String,
        @Query("q") q: String,
        @Query("image_type") imageType: String,
    ): Response<PhotoResponse>
}