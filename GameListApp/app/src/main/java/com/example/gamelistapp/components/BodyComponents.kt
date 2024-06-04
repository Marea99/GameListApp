package com.example.gamelistapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun MainImage(imgUrl: String, modifier: Modifier = Modifier) {
    AsyncImage(
        model = imgUrl,
        contentDescription = null,
        modifier = modifier
    )
}

@Composable
fun MetascoreCard(score: Int, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .size(width = 80.dp, height = 88.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (score >= 70) Color(0xFF348838)
                             else if (score >= 50) Color(0xFFC79600)
                             else Color(0xFFC52418),
            contentColor = Color.White,
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = score.toString(),
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun GameCardListItem(imgUrl: String, title: String, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        MainImage(imgUrl, Modifier.clip(RoundedCornerShape(8.dp)))
        Text(text = title, style = MaterialTheme.typography.titleMedium)
    }
}
