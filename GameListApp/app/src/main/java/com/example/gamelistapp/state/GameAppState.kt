package com.example.gamelistapp.state

data class GameAppState(
    val name: String = "",
    val description_raw: String = "",
    val metacritic: Int = 0,
    val released: String = "",
    val background_image: String = "",
    val website: String = ""
)