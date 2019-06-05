package com.example.coincap.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinListing(
    @SerializedName("data")
    @Expose
    val `data`: List<Coin>,
    @SerializedName("status")
    @Expose
    val status: Status
)