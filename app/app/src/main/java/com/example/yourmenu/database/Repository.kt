package com.example.yourmenu.database

import androidx.lifecycle.LiveData
import com.example.yourmenu.dataclasses.Dish

class Repository(private val dao: DAO) {

    val allDishes: LiveData<List<Dish>> = dao.getAllDishes()
    suspend fun insertDish(dish: Dish) { dao.insertDish(dish)}
}