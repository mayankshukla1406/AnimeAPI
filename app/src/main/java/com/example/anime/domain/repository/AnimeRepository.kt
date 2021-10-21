package com.example.anime.domain.repository

import com.example.anime.data.data_source.dto.AnimeDTO

interface AnimeRepository {

    suspend fun getAnimeList() : AnimeDTO

    suspend fun getAnimeById(id:String) : AnimeDTO
}