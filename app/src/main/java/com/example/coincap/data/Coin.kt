package com.example.coincap.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Coin(
    @SerializedName("circulating_supply")
    @Expose
    val circulatingSupply: Double,

    @SerializedName("cmc_rank")
    @Expose
    val cmcRank: Float,

    @SerializedName("id")
    @Expose
    val id: Int,

    @SerializedName("last_updated")
    @Expose
    val lastUpdated: String,

    @SerializedName("max_supply")
    @Expose
    val maxSupply: Float,

    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("num_market_pairs")
    @Expose
    val num_market_pairs: Float,


    @SerializedName("slug")
    @Expose
    val slug: String,

    @SerializedName("symbol")
    @Expose
    val symbol: String,

    @SerializedName("total_supply")
    @Expose
    val totalSupply: Float
)


