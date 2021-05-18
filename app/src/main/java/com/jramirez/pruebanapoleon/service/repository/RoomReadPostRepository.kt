package com.jramirez.pruebanapoleon.service.repository

import com.jramirez.pruebanapoleon.service.room.entity.ReadPostEntity

interface RoomReadPostRepository {

    suspend fun saveReadPost(post: ReadPostEntity)

    suspend fun checkPost(postId: Int): Boolean
}