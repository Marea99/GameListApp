package com.example.gamelistapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gamelistapp.viewModel.GamesViewModel
import com.example.gamelistapp.views.DetailGameScreen
import com.example.gamelistapp.views.HomeScreen
import com.example.gamelistapp.views.SearchGameScreen

@Composable
fun NavManager(viewModel: GamesViewModel) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.HomeScreen.route
    ) {
        composable(Routes.HomeScreen.route) {
            HomeScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable(Routes.DetailGameScreen.route) { backStackEntry ->
            DetailGameScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable(Routes.SearchGameScreen.route){
            SearchGameScreen(navController = navController, viewModel = viewModel )
        }
    }
}