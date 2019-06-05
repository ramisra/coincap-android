package com.example.coincap.di

import com.example.coincap.data.CoinCapApiInterface
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class CoinModule {

    @Provides
    @Singleton
    fun providesCoinService(retrofit: Retrofit):  CoinCapApiInterface{
        return retrofit.create(CoinCapApiInterface::class.java)
    }
}