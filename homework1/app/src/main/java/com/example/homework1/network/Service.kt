package com.example.homework1.network

import com.example.homework1.network.models.CharactersResponse
import retrofit2.Response
import retrofit2.http.GET

interface Service {
    @GET("api/character/")
    suspend fun getCharacters(): Response<CharactersResponse>
}