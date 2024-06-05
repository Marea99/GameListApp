package com.example.gamelistapp.repository

import com.example.gamelistapp.data.ApiGames
import com.example.gamelistapp.model.SingleGameDetailModel
import com.example.gamelistapp.model.SingleGameModel
import javax.inject.Inject

class GameRepository @Inject constructor(private val apiGames: ApiGames) {

    suspend fun getAllGames(): List<SingleGameModel>? {
        val response = apiGames.getAllGames()

        if (response.isSuccessful) {
            return response.body()?.results
        }
        return null
    }

    suspend fun getGame(id:Int): SingleGameDetailModel? {
        val response = apiGames.getGame(id)

        if (response.isSuccessful) {
            return response.body()
        }
        return null
    }

    suspend fun getGameByName(name: String): SingleGameDetailModel? {
        val response = apiGames.getGameByName(name)

        if (response.isSuccessful){
            return response.body()
        }
        return null
    }
}