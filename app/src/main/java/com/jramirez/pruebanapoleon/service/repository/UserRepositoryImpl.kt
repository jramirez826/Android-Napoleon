package com.jramirez.pruebanapoleon.service.repository

import com.jramirez.pruebanapoleon.model.User
import com.jramirez.pruebanapoleon.service.Resource

class UserRepositoryImpl : UserRepository {

    override suspend fun getUser(userId: Int): Resource<User> =
        handleAPICall {
            client.getUser(userId)
        }
}