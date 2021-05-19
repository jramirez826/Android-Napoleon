package com.jramirez.pruebanapoleon.service.repository

import com.jramirez.pruebanapoleon.app.NapoleonApplication
import com.jramirez.pruebanapoleon.model.Post
import com.jramirez.pruebanapoleon.service.Resource
import com.jramirez.pruebanapoleon.service.room.dao.FavoritePostDao

class PostRepositoryImpl(
    private val favoritePostDao: FavoritePostDao = NapoleonApplication.database.favoritePostDao()
) : PostRepository {

    override suspend fun getPosts(): Resource<List<Post>> {
        val response = handleAPICall {
            client.getPosts()
        }
        response.data?.forEach {
            it.isFavorite = favoritePostDao.isExistPost(it.id)
        }
        return response
    }

}