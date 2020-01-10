package com.example.yourmenu.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.yourmenu.dataclasses.Dish
import kotlinx.coroutines.launch

class ViewModel(application: Application): AndroidViewModel(application) {

    private val repository: Repository
    val allDishes: LiveData<List<Dish>>

    init {
        val dao = Room.databaseBuilder( // TODO : do it in a singleton
            application.applicationContext,
            AppDatabase::class.java,
            "DishDatabase"
        ).build().getDAO()
        repository = Repository(dao)
        allDishes = repository.allDishes
    }

    fun insertDish(dish: Dish) = viewModelScope.launch {
        repository.insertDish(dish)
    }
}