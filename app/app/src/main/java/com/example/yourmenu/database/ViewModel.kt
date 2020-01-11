package com.example.yourmenu.database

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.yourmenu.dataclasses.Dish
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModel(application: Application): AndroidViewModel(application) {

    private val repository: Repository
    val remoteDishes = MutableLiveData<List<Dish>>()
    val localDishes: LiveData<List<Dish>>

    init {
        val dao = Room.databaseBuilder( // TODO : do it in a singleton
            application.applicationContext,
            AppDatabase::class.java,
            "DishDatabase"
        ).build().getDAO()
        repository = Repository(dao)
        localDishes = repository.allDishes

        // Remote dishes are loaded only at start-up //TODO: call remote dishes on adding new dish
        // requestNetworkDishes()
    }

    fun insertDish(dish: Dish) = viewModelScope.launch {
        repository.insertDish(dish)
    }

    private fun requestNetworkDishes() {
        Api.retrofitService.getRemoteDishes().enqueue(
            object: Callback<List<Dish>> {
                override fun onFailure(call: Call<List<Dish>>, t: Throwable) {
                    remoteDishes.value = null // TODO: make it clean
                    Log.e("network request", t.message)
                }

                override fun onResponse(call: Call<List<Dish>>, response: Response<List<Dish>>) {
                    remoteDishes.value = response.body()
                }
            }
        )
    }
}