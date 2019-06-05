package com.example.coincap.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Quote(

    @SerializedName("BTC")
    @Expose
    val BTC: CoinPairStats,

    @SerializedName("USD")
    @Expose
    val USD: CoinPairStats
)