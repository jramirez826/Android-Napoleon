package com.jramirez.pruebanapoleon.service.repository

import androidx.lifecycle.LiveData
import com.jramirez.pruebanapoleon.model.Post
import com.jramirez.pruebanapoleon.service.room.entity.FavoritePostEntity

interface RoomFavoritePostRepository {

    suspend fun savePost(post: Post)
    suspend fun deletePost(postId: Int)
    suspend fun getPosts(): LiveData<List<FavoritePostEntity>>
}