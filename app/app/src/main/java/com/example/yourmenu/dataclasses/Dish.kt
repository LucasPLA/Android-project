package com.example.yourmenu.dataclasses

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Dish(
    @PrimaryKey var name: String,
    var appreciation: Int,
    var Difficulty: Int
)