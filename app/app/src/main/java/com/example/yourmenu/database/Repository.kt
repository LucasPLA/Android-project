package com.example.yourmenu.database

import androidx.lifecycle.LiveData
import com.example.yourmenu.dataclasses.Dish
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

class Repository(private val dao: DAO) {

    val allDishes: LiveData<List<Dish>> = dao.getAllDishes()
    suspend fun insertDish(dish: Dish) { dao.insertDish(dish)}

}

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl("http://localhost:8080/") // TODO : passer la valeur dans les values
    .build()

interface ApiService {
    @GET("getDishes")
    fun getRemoteDishes():
            Call<List<Dish>>
}

object Api {
    val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}