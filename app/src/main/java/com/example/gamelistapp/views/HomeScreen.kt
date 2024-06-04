package com.example.gamelistapp.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gamelistapp.components.GameCardListItem
import com.example.gamelistapp.components.MetascoreCard
import com.example.gamelistapp.navigation.Routes
import com.example.gamelistapp.viewModel.GamesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, viewModel: GamesViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                title = { Text(text = "GAME LIST APP") },
                actions = {
                    IconButton(onClick = { navController.navigate(Routes.SearchGameScreen.route) }) {
                        Icon(
                            imageVector = Icons.Rounded.Search,
                            contentDescription = "Search"
                        )
                    }
                }
            )
        }
    ) {
        HomeBodyScreen(it, navController, viewModel)
    }
}

@Composable
fun HomeBodyScreen(paddingValues: PaddingValues,navController: NavController, viewModel: GamesViewModel) {
    // https://api.rawg.io/api/games/3328?key=2234cb7386014ac9a1d4207c02e63d27
    LazyColumn(
        modifier = Modifier.padding(paddingValues)
    ) {
        item {
            GameCardListItem(
                "https://media.rawg.io/media/games/618/618c2031a07bbff6b4f611f10b6bcdbc.jpg",
                "The Witcher 3: Wild Hunt"
            ) {
                navController.navigate(Routes.DetailGameScreen.route)
            }
        }
        item {
            GameCardListItem(
                "https://media.rawg.io/media/games/4be/4be6a6ad0364751a96229c56bf69be59.jpg",
                "God of War (2018)"
            ) {
                navController.navigate(Routes.DetailGameScreen.route)
            }
        }
    }
}