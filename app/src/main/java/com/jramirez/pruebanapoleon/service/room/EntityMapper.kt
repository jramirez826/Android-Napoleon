package com.jramirez.pruebanapoleon.service.room

import com.jramirez.pruebanapoleon.model.Post
import com.jramirez.pruebanapoleon.service.room.entity.FavoritePostEntity
import com.jramirez.pruebanapoleon.service.room.entity.ReadPostEntity

object EntityMapper {

    fun mapToFavoritePostEntity(post: Post) =
        FavoritePostEntity(
            post.userId,
            post.id,
            post.title,
            post.body
        )

    fun mapToPost(post: FavoritePostEntity) =
        Post(
            post.userId,
            post.id,
            post.title,
            post.body,
            true
        )

    fun mapToReadPostEntity(postId: Int) =
        ReadPostEntity(postId)
}