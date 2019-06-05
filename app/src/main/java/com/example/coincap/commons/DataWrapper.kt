package com.example.coincap.commons

data class DataWrapper<T>(
    val data: T? = null,
    val error: String?
)