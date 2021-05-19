package com.jramirez.pruebanapoleon.service.repository

import com.jramirez.pruebanapoleon.app.NapoleonApplication
import com.jramirez.pruebanapoleon.service.room.EntityMapper
import com.jramirez.pruebanapoleon.service.room.dao.ReadPostDao

class RoomReadPostRepositoryImpl(
    private val readPostDao: ReadPostDao = NapoleonApplication.database.readPostDao()
) : RoomReadPostRepository {

    override suspend fun saveReadPost(postId: Int) {
        val entity = EntityMapper.mapToReadPostEntity(postId)
        readPostDao.insertReadPost(entity)
    }

    override suspend fun checkPost(postId: Int): Boolean = readPostDao.isExistPost(postId)
}