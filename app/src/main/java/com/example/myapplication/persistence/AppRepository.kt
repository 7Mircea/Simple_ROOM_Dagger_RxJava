package com.example.myapplication.persistence

import com.example.myapplication.utilities.doOnBackground


class AppRepository(val db:AppDatabase) {

    fun insertOne(plant: Plant) {
        doOnBackground() {
            db.plantDao().insertOne(plant)
        }
    }
}