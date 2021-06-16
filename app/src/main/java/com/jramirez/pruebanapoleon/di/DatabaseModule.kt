package com.jramirez.pruebanapoleon.di

import android.content.Context
import androidx.room.Room
import com.jramirez.pruebanapoleon.service.room.PostDatabase
import com.jramirez.pruebanapoleon.service.room.dao.FavoritePostDao
import com.jramirez.pruebanapoleon.service.room.dao.ReadPostDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): PostDatabase {
        return Room.databaseBuilder(
            context,
            PostDatabase::class.java,
            "post.db"
        ).build()
    }

    @Provides
    fun provideFavoritePostDao(database: PostDatabase): FavoritePostDao =
        database.favoritePostDao()

    @Provides
    fun provideReadPostDao(database: PostDatabase): ReadPostDao =
        database.readPostDao()
}