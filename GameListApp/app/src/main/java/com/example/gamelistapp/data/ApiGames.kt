package com.example.gamelistapp.data

import com.example.gamelistapp.constant.Constants.Companion.GAMES
import com.example.gamelistapp.constant.Constants.Companion.KEY
import com.example.gamelistapp.model.GamesListModel
import com.example.gamelistapp.model.SingleGameDetailModel
import com.example.gamelistapp.model.SingleGameModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiGames{
    @GET(GAMES + KEY)
    suspend fun getAllGames(): Response<GamesListModel>

    @GET("$GAMES/{id}$KEY")
    suspend fun getGame(@Path(value = "id")id: Int): Response<SingleGameDetailModel>

    @GET("$GAMES/{name}$KEY")
    suspend fun getGameByName(@Path(value = "name")id: String): Response<SingleGameDetailModel>
}