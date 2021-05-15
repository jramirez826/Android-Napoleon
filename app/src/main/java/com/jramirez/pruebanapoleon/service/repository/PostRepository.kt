package com.jramirez.pruebanapoleon.service.repository

import com.jramirez.pruebanapoleon.model.Post
import com.jramirez.pruebanapoleon.service.Resource

interface PostRepository: BaseRepository {

    suspend fun getPosts(): Resource<List<Post>>
}