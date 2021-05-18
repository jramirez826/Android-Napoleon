package com.jramirez.pruebanapoleon.service.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jramirez.pruebanapoleon.service.room.dao.FavoritePostDao
import com.jramirez.pruebanapoleon.service.room.dao.ReadPostDao
import com.jramirez.pruebanapoleon.service.room.entity.FavoritePostEntity
import com.jramirez.pruebanapoleon.service.room.entity.ReadPostEntity

@Database(
    entities = [ReadPostEntity::class, FavoritePostEntity::class],
    version = 1
)
abstract class PostDatabase : RoomDatabase() {

    abstract fun readPostDao(): ReadPostDao
    abstract fun favoritePostDao(): FavoritePostDao
}