package com.example.coincap.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coin_table")
data class CoinModel(

    val maxSupply: Float,
    val name: String,
    @PrimaryKey
    val id: Int
)