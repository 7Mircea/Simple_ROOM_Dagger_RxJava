package com.example.myapplication.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.utilities.Constants

@Database(entities = [Plant::class],version = 1,exportSchema = false)
abstract class AppDatabase:RoomDatabase() {

    companion object {
        private var db:AppDatabase? = null
        fun getInstance(context: Context):AppDatabase {
            if (db == null) {
                synchronized(AppDatabase::class) {
                    if(db==null) {
                        db = Room.databaseBuilder(
                            context.applicationContext,
                            AppDatabase::class.java,
                            Constants.DATABASE_NAME
                        ).build()
                    }
                }
            }
            return db!!
        }
    }
    abstract fun plantDao():PlantDao
}