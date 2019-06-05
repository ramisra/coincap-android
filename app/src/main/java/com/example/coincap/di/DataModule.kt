package com.example.coincap.di

import android.content.Context
import androidx.room.Room
import com.example.coincap.CoinCapDb
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun roomDb(context: Context): CoinCapDb {
        return Room.databaseBuilder(
            context.applicationContext,
            CoinCapDb::class.java,
            "coincapdb"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}