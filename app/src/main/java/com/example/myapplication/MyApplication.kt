package com.example.myapplication

import android.app.Application
import com.example.myapplication.di.DaggerSingletonComponent
import com.example.myapplication.di.RoomModule
import com.example.myapplication.di.SingletonComponent

class MyApplication: Application() {
    private lateinit var component: SingletonComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerSingletonComponent.builder()
            .roomModule(RoomModule(this))
            .build()
    }

    fun getComponent():SingletonComponent = component
}