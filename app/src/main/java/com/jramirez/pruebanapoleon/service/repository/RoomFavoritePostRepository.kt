package com.jramirez.pruebanapoleon.service.repository

import androidx.lifecycle.LiveData
import com.jramirez.pruebanapoleon.model.Post

interface RoomFavoritePostRepository {

    suspend fun savePost(post: Post)
    suspend fun deletePost(postId: Int)
    fun getPosts(): LiveData<List<Post>>
}