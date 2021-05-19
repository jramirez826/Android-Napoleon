package com.jramirez.pruebanapoleon.service.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.jramirez.pruebanapoleon.app.NapoleonApplication
import com.jramirez.pruebanapoleon.model.Post
import com.jramirez.pruebanapoleon.service.room.EntityMapper
import com.jramirez.pruebanapoleon.service.room.dao.FavoritePostDao

class RoomFavoritePostRepositoryImpl(
    private val favoritePostDao: FavoritePostDao = NapoleonApplication.database.favoritePostDao()
) :
    RoomFavoritePostRepository {

    override suspend fun savePost(post: Post) {
        val postEntity = EntityMapper.mapToFavoritePostEntity(post)
        favoritePostDao.insertPost(postEntity)
    }

    override suspend fun deletePost(postId: Int) {
        favoritePostDao.deletePost(postId)
    }

    override fun getPosts(): LiveData<List<Post>> =
        Transformations.map(
            favoritePostDao.getPosts()
        ) { entities ->
            entities.map { EntityMapper.mapToPost(it) }
        }

}