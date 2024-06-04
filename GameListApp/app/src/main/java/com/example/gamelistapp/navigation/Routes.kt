package com.example.gamelistapp.navigation

sealed class Routes (val route: String) {

    object HomeScreen: Routes("HomeScreen")

    object DetailGameScreen: Routes("DetailGameScreen/{id}"){
        fun createRoute(id: Int) = "DetailGameScreen/$id"
    }

    object SearchGameScreen: Routes("SearchGameScreen")

}