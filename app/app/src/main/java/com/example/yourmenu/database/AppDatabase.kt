package com.example.yourmenu.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.yourmenu.dataclasses.Dish

@Database(entities = arrayOf(Dish::class), version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun getDAO(): DAO
}