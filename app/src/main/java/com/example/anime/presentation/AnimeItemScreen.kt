package com.example.anime.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.anime.domain.model.AnimeData

@Composable
fun AnimeItemScreen(
    anime:AnimeData,
    modifier: Modifier = Modifier
){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text="${anime.titles}",
        style = MaterialTheme.typography.h6,
        overflow = TextOverflow.Ellipsis,
        color= Color.Red
        )
        Text(text="Description : ${anime.descriptions}",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis)
        Text(text="Episodes Count : ${anime.episodes_count}",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis)
        Text(text="StartDate : ${anime.start_date}",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis)
        Text(text="EndDate : ${anime.end_date}",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis)
        Text(text="TrailerUrl : ${anime.trailer_url}",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis)
    }

}