package com.example.coincap.data

import io.reactivex.Flowable
import retrofit2.http.GET

interface CoinCapApiInterface {

    @GET("/v1/cryptocurrency/listings/latest")
    fun getLatestCryptoListing(): Flowable<CoinListing>

}