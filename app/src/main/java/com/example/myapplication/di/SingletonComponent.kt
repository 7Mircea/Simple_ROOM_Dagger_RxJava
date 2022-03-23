package com.example.myapplication.di

import com.example.myapplication.persistence.AppDatabase
import com.example.myapplication.persistence.PlantDao
import com.example.myapplication.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RoomModule::class])
interface SingletonComponent {
    fun inject(activity: MainActivity)

}