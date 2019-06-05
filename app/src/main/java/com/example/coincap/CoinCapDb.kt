package com.example.coincap

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.coincap.dao.CoinCapDao
import com.example.coincap.models.CoinModel

@Database(
    entities = [CoinModel::class],
    version = 1,
    exportSchema = true
)
abstract class CoinCapDb : RoomDatabase() {

    abstract fun coinCapDao():CoinCapDao
}