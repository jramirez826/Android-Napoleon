package com.jramirez.pruebanapoleon.service.room

import com.jramirez.pruebanapoleon.model.Post
import com.jramirez.pruebanapoleon.service.room.entity.FavoritePostEntity

object EntityMapper {

    fun mapToFavoritePostEntity(post: Post) =
        FavoritePostEntity(
            post.userId,
            post.id,
            post.title,
            post.body
        )
}