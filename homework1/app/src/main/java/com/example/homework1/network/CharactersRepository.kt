package com.example.homework1.network

import android.util.Log
import com.example.homework1.network.models.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharactersRepository(private val service: Service) {
    suspend fun loadCharacters(): List<Character>? {
        val response = service.getCharacters()
        return response.body()?.items
    }



}