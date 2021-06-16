package com.jramirez.pruebanapoleon.app

import android.app.Application
import androidx.room.Room
import com.jramirez.pruebanapoleon.service.room.PostDatabase
import dagger.hilt.android.HiltAndroidApp

class NapoleonApplication : Application() {

    companion object {
        lateinit var database: PostDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
                this,
                PostDatabase::class.java,
                "post_database"
        ).build()
    }
}