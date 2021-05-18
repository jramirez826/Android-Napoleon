package com.jramirez.pruebanapoleon.service.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jramirez.pruebanapoleon.service.room.entity.FavoritePostEntity

@Dao
interface FavoritePostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPost(post: FavoritePostEntity)

    @Query("DELETE FROM favorite_post_table WHERE id = :id")
    suspend fun deletePost(id: Int)

    @Query("SELECT * FROM favorite_post_table")
    fun getPosts(): LiveData<List<FavoritePostEntity>>
}