package com.jramirez.pruebanapoleon.service

import com.jramirez.pruebanapoleon.model.Post
import retrofit2.http.GET

interface JSONPlaceholderAPI {

    @GET("posts")
    suspend fun getPosts(): List<Post>
}