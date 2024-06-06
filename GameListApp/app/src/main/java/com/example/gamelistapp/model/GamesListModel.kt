package com.example.gamelistapp.model

import com.google.gson.annotations.SerializedName

data class GamesListModel(
    @SerializedName("count") val count: Int,
    val next: String,
    val results: List<SingleGameModel>
)
/*
data class Game(
    val id: Int,
    val name: String,
    val backgroundImage: String
) */