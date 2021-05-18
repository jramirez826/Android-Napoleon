package com.jramirez.pruebanapoleon.service.repository

import com.jramirez.pruebanapoleon.service.room.dao.ReadPostDao
import com.jramirez.pruebanapoleon.service.room.entity.ReadPostEntity

class RoomReadPostRepositoryImpl(private val readPostDao: ReadPostDao) : RoomReadPostRepository {

    override suspend fun saveReadPost(post: ReadPostEntity) {
        readPostDao.insertReadPost(post)
    }

    override suspend fun checkPost(postId: Int): Boolean = readPostDao.isExistPost(postId)
}