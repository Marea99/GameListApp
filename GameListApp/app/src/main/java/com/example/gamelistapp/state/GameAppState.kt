package com.example.gamelistapp.state

data class GameAppState(
    val name: String = "",
    val description: String = "",
    val metacritic: Int = 0,
    val released: String = "",
    val backgroundImage: String = "",
    val website: String = ""
)