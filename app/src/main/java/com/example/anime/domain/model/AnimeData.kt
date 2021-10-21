package com.example.anime.domain.model

import com.example.anime.data.data_source.dto.Descriptions
import com.example.anime.data.data_source.dto.Titles

data class AnimeData(
    val descriptions: String?,
    val end_date: String?,
    val episodes_count: Int?,
    val start_date: String?,
    val titles: String?,
    val trailer_url: String?
)
