package com.example.myapplication.persistence

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.utilities.Constants.Companion.PLANT_TABLE

@Dao
interface PlantDao {
//    @Insert
//    fun insertAll(plant: Plant)

    @Query("SELECT * FROM $PLANT_TABLE")
    fun selectPlant():List<Plant>

    @Insert
    fun insertOne(plant: Plant);

    @Delete
    fun deleteOne(plant: Plant);
}