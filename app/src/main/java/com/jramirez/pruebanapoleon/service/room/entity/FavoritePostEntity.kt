package com.jramirez.pruebanapoleon.service.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_post_table")
data class FavoritePostEntity(
    val userId: Int,
    @PrimaryKey val id: Int,
    val title: String,
    val body: String
)
