package com.example.gamelistapp.views

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gamelistapp.components.MainImage
import com.example.gamelistapp.components.MetascoreCard
import com.example.gamelistapp.viewModel.GamesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailGameScreen(navController: NavController, viewModel: GamesViewModel) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                title = { Text(text = "God of War (2018)") /* TODO: put game name from api */ },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Rounded.ArrowBack,
                            contentDescription = "Go back"
                        )
                    }
                }
            )
        }
    ) {
        DetailGameBodyScreen(it, viewModel)
    }
}

@Composable
fun DetailGameBodyScreen(paddingValues: PaddingValues, viewModel: GamesViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .verticalScroll(enabled = true, state = ScrollState(0))
    ) {
        MainImage(imgUrl = "https://media.rawg.io/media/games/4be/4be6a6ad0364751a96229c56bf69be59.jpg")

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "METASCORE",
                    style = MaterialTheme.typography.headlineLarge
                )
                
                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = { /* TODO */ }
                ) {
                    Text(text = "Sitio web")
                }
            }
            MetascoreCard(score = 94)
        }

        Text(
            text = "It is a new beginning for Kratos. Living as a man outside the shadow of the gods, he ventures into the brutal Norse wilds with his son Atreus, fighting to fulfill a deeply personal quest. </p>\\n<p>His vengeance against the Gods of Olympus years behind him, Kratos now lives as a man in the realm of Norse Gods and monsters. It is in this harsh, unforgiving world that he must fight to survive… And teach his son to do the same. This startling reimagining of God of War deconstructs the core elements that defined the series—satisfying combat; breathtaking scale; and a powerful narrative—and fuses them anew. </p>\\n<p>Kratos is a father again. As mentor and protector to Atreus, a son determined to earn his respect, he is forced to deal with and control the rage that has long defined him while out in a very dangerous world with his son. </p>\\n<p>From the marble and columns of ornate Olympus to the gritty forests, mountains, and caves of Pre-Viking Norse lore, this is a distinctly new realm with its own pantheon of creatures, monsters, and gods. With an added emphasis on discovery and exploration, the world will draw players in to explore every inch of God of War’s breathtakingly threatening landscape—by far the largest in the franchise. </p>\\n<p>With an over the shoulder free camera that brings the player closer to the action than ever before, fights in God of War mirror the pantheon of Norse creatures Kratos will face: grand, gritty, and grueling. A new main weapon and new abilities retain the defining spirit of God of War while presenting a vision of violent conflict that forges new ground in the genre",
            modifier = Modifier.padding(8.dp)
        )
    }
}