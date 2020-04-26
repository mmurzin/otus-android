package com.example.homework1.network.models

import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    @SerializedName("results") val items: List<Character>
)