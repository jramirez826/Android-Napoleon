package com.jramirez.pruebanapoleon.service.repository

import androidx.lifecycle.LiveData
import com.jramirez.pruebanapoleon.service.room.entity.FavoritePostEntity

interface RoomFavoritePostRepository {

    suspend fun savePost(post: FavoritePostEntity)
    suspend fun deletePost(postId: Int)
    suspend fun getPosts(): LiveData<List<FavoritePostEntity>>
}