package com.example.coincap.di

import com.example.coincap.viewModels.CoinCapViewModel
import dagger.Component
import javax.inject.Singleton

@Component(modules = [CoreModule::class, CoinModule::class, DataModule::class])

@Singleton
interface CoinCapComponent {
    fun inject(coinCapViewModel: CoinCapViewModel)

}