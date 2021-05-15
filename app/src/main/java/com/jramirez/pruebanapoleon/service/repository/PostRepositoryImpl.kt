package com.jramirez.pruebanapoleon.service.repository

import com.jramirez.pruebanapoleon.model.Post
import com.jramirez.pruebanapoleon.service.Resource

class PostRepositoryImpl: PostRepository {

    override suspend fun getPosts(): Resource<List<Post>> =
        handleAPICall{
            client.getPosts()
        }
}