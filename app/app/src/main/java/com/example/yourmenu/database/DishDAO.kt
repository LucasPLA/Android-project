package com.example.yourmenu.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.yourmenu.dataclasses.Dish

@Dao
interface DAO {

    @Insert
    suspend fun insertDish(vararg dish: Dish)

    @Query("SELECT * FROM Dish")
    fun getAllDishes(): LiveData<List<Dish>>
}