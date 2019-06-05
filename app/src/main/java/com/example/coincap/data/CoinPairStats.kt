package com.example.coincap.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinPairStats(

    @SerializedName("market_cap")
    @Expose
    val marketCap: Long,

    @SerializedName("percent_change_1h")
    @Expose
    val percentChange1h: Double,

    @SerializedName("percent_change_24h")
    @Expose
    val percentChange24h: Double,

    @SerializedName("percent_change_7d")
    @Expose
    val percentChange7d: Double,

    @SerializedName("price")
    @Expose
    val price: Double,

    @SerializedName("volume_24h")
    @Expose
    val volume24h: Long
)