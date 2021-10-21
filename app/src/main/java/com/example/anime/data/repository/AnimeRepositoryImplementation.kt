package com.example.anime.data.repository

import com.example.anime.data.data_source.dto.AnimeDTO
import com.example.anime.data.data_source.dto.AnimeInstanceAPI
import com.example.anime.domain.repository.AnimeRepository
import javax.inject.Inject

class AnimeRepositoryImplementation @Inject constructor(
    private val api : AnimeInstanceAPI
) :AnimeRepository{
    override suspend fun getAnimeList(): AnimeDTO {
        return api.getAnimeList()
    }

    override suspend fun getAnimeById(id:String): AnimeDTO {
        return api.getAnimeById(id)
    }

}