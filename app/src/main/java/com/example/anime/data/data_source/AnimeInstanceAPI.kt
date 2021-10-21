package com.example.anime.data.data_source.dto

import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeInstanceAPI {

    @GET("/v1/anime")
    suspend fun getAnimeList() : AnimeDTO

    @GET("v1/anime/{id}")
    suspend fun getAnimeById(@Path("id") id : String) : AnimeDTO
}