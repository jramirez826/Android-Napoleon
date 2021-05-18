package com.jramirez.pruebanapoleon.service.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "read_post_table")
data class ReadPostEntity(@PrimaryKey val postId: Int)
