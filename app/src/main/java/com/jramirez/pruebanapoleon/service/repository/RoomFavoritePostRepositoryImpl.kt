package com.jramirez.pruebanapoleon.service.repository

import androidx.lifecycle.LiveData
import com.jramirez.pruebanapoleon.service.room.dao.FavoritePostDao
import com.jramirez.pruebanapoleon.service.room.entity.FavoritePostEntity

class RoomFavoritePostRepositoryImpl(private val favoritePostDao: FavoritePostDao) :
    RoomFavoritePostRepository {

    override suspend fun savePost(post: FavoritePostEntity) {
        favoritePostDao.insertPost(post)
    }

    override suspend fun deletePost(postId: Int) {
        favoritePostDao.deletePost(postId)
    }

    override suspend fun getPosts(): LiveData<List<FavoritePostEntity>> = favoritePostDao.getPosts()

}