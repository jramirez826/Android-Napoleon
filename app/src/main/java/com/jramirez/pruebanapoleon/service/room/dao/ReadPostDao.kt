package com.jramirez.pruebanapoleon.service.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jramirez.pruebanapoleon.service.room.entity.ReadPostEntity

@Dao
interface ReadPostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReadPost(post: ReadPostEntity)

    @Query("SELECT EXISTS(SELECT * FROM read_post_table WHERE postId = :id)")
    suspend fun isExistPost(id: Int): Boolean
}