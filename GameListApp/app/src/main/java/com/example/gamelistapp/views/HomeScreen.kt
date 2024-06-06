package com.example.gamelistapp.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
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
    val allGames by viewModel.allGames.collectAsState()

    viewModel.getAllGames()
    LazyColumn(
        modifier = Modifier.padding(paddingValues)
    ) {
        items(allGames) { item ->
            GameCardListItem(imgUrl = item.background_image, title = item.name) {
                viewModel.setIdGame(item.id)
                navController.navigate(Routes.DetailGameScreen.route)
            }
        }
        /*
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                IconButton(onClick = { viewModel.getMoreGames() }) {
                    Icon(imageVector = Icons.Rounded.Refresh,
                        contentDescription = "Get more games")
                }
            }
        }
        */
    }
}