package com.jramirez.pruebanapoleon.service.repository

interface RoomReadPostRepository {

    suspend fun saveReadPost(postId: Int)

    suspend fun checkPost(postId: Int): Boolean
}