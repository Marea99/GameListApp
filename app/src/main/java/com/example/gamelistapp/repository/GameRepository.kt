package com.example.gamelistapp.repository

import com.example.gamelistapp.data.ApiGames
import javax.inject.Inject

class GameRepository @Inject constructor(
    private val apiGames: ApiGames
) {
}