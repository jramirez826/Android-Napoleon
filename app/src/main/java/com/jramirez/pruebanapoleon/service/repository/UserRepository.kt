package com.jramirez.pruebanapoleon.service.repository

import com.jramirez.pruebanapoleon.model.User
import com.jramirez.pruebanapoleon.service.Resource

interface UserRepository : BaseRepository{

    suspend fun getUser(userId: Int): Resource<User>
}