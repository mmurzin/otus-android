package com.example.homework1

import com.example.homework1.network.CharactersRepository
import com.example.homework1.network.Service
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Provider {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/")
        .client(getClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun getClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient
            .Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    val repository =
        CharactersRepository(retrofit.create(Service::class.java))
}