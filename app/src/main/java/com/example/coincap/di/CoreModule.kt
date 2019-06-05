package com.example.coincap.di

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton



@Module
class CoreModule {

    private val onlineInterceptor = Interceptor {
        val response = it.proceed(it.request())
        response.newBuilder()
            .removeHeader("Pragma")
            .removeHeader("Cache-Control")
            .header("X-CMC_PRO_API_KEY", "f2e96055-4384-468a-8d6f-c657507ad9aa")
            .build()
    }


    @Provides
    @Singleton
    fun  providesRetrofitClient(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pro-api.coinmarketcap.com/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor { chain ->
            val original = chain.request()
            val builder = original.newBuilder().method(original.method(), original.body())
            builder.header("X-CMC_PRO_API_KEY", "f2e96055-4384-468a-8d6f-c657507ad9aa")
            chain.proceed(builder.build())
        }
            .build()
    }

}