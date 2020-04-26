package com.example.homework1.network.models

import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: String
)