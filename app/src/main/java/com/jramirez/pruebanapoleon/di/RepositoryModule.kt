package com.jramirez.pruebanapoleon.di

import com.jramirez.pruebanapoleon.service.repository.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindPostRepository(impl: PostRepositoryImpl)
            : PostRepository

    @Binds
    abstract fun bindRoomFavoritePostRepository(impl: RoomFavoritePostRepositoryImpl)
            : RoomFavoritePostRepository

    @Binds
    abstract fun bindRoomReadPostRepository(impl: RoomReadPostRepositoryImpl)
            : RoomReadPostRepository

    @Binds
    abstract fun bindUserRepository(impl: UserRepositoryImpl)
            : UserRepository
}