package com.example.myapplication.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.persistence.AppDatabase
import com.example.myapplication.persistence.AppRepository
import com.example.myapplication.utilities.Constants.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule(application: Application) {
    private val database: AppDatabase = AppDatabase.getInstance(application)

    @Singleton
    @Provides
    fun provideRepository(db:AppDatabase):AppRepository = AppRepository(db)

    @Singleton
    @Provides
    fun provideDatabase():AppDatabase = database

    @Singleton
    @Provides
    fun providePlantDao(db:AppDatabase) = db.plantDao()
}