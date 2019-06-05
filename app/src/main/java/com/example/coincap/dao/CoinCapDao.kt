package com.example.coincap.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.coincap.models.CoinModel
import io.reactivex.Flowable

@Dao
interface CoinCapDao {

    @Query("SELECT * from  coin_table ORDER BY name ASC")
    fun getAllWords(): Flowable<List<CoinModel>>

    @Insert
    fun insert(coin: CoinModel)
}