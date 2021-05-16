package com.jramirez.pruebanapoleon.service

import com.jramirez.pruebanapoleon.model.Post
import com.jramirez.pruebanapoleon.model.User
import retrofit2.http.GET
import retrofit2.http.Path

interface JSONPlaceholderAPI {

    @GET("posts")
    suspend fun getPosts(): List<Post>

    @GET("user/{userId}")
    suspend fun getUser(@Path("userId") userId: Int): User
}