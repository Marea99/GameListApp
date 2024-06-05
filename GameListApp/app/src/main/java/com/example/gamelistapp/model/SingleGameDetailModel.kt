package com.example.gamelistapp.model

data class SingleGameDetailModel(
    val id: Int,
    val name: String,
    val description_raw: String,
    val metacritic: Int,
    val released: String,
    val background_image: String,
    val website: String
)