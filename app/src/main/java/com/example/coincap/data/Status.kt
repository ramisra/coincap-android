package com.example.coincap.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Status(

    @SerializedName("credit_count")
    @Expose
    val creditCount: Int,

    @SerializedName("elapsed")
    @Expose
    val elapsed: Int,

    @SerializedName("error_code")
    @Expose
    val errorCode: Int,

    @SerializedName("error_message")
    @Expose
    val error_message: String,

    @SerializedName("timestamp")
    @Expose
    val timestamp: String
)