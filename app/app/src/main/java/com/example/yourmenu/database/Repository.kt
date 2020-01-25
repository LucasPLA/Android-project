package com.example.yourmenu.database

import androidx.lifecycle.LiveData
import com.example.yourmenu.dataclasses.Dish
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

class Repository(private val dao: DAO) {

    val allDishes: LiveData<List<Dish>> = dao.getAllDishes()
    suspend fun insertDish(dish: Dish) { dao.insertDish(dish)}
    suspend fun nukeTable() { dao.nukeTable()}
}

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl("http://10.0.2.2:8080/") // TODO : put this value in a utils file
    .build()

interface ApiService {
    @GET("/getDishes")
    fun getRemoteDishes():
            Call<List<Dish>>
}

object Api {
    val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}