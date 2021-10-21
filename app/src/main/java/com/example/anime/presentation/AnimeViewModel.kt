package com.example.anime.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.anime.common.Events
import com.example.anime.domain.use_case.AnimeGetUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val animeUseCase : AnimeGetUseCase
) : ViewModel() {

    private val stateAnime = mutableStateOf(AnimeListState())
    val state: State<AnimeListState> = stateAnime

    init {
        getAnimeList()
    }

    private fun getAnimeList() {
        animeUseCase().onEach {
            when (it) {
                is Events.Success -> {
                    stateAnime.value = AnimeListState(animeList = it.data ?: emptyList())
                }
                is Events.Loading -> {
                    stateAnime.value = AnimeListState(isLoading = true)
                }
                is Events.Error -> {
                    stateAnime.value = AnimeListState(error = it.message ?: "An Unexpected Error")
                }
            }
        }.launchIn(viewModelScope)
    }
}