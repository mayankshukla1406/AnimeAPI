package com.example.anime.di

import com.example.anime.common.Constant
import com.example.anime.data.data_source.dto.AnimeInstanceAPI
import com.example.anime.data.repository.AnimeRepositoryImplementation
import com.example.anime.domain.repository.AnimeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AnimeModule {

    @Provides
    @Singleton
    fun provideApi():AnimeInstanceAPI{
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AnimeInstanceAPI::class.java)
    }
    @Provides
    @Singleton
    fun provideAnimeRepository(api:AnimeInstanceAPI):AnimeRepository{
        return AnimeRepositoryImplementation(api)
    }
}