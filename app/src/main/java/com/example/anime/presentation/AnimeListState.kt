package com.example.anime.presentation

import com.example.anime.domain.model.AnimeData

data class AnimeListState(
    val isLoading : Boolean = false,
    val animeList : List<AnimeData> = emptyList(),
    val error : String = ""
)
