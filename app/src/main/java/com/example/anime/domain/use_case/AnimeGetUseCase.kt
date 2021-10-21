package com.example.anime.domain.use_case

import com.example.anime.common.Events
import com.example.anime.data.data_source.dto.toAnimeData
import com.example.anime.domain.model.AnimeData
import com.example.anime.domain.repository.AnimeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class AnimeGetUseCase @Inject constructor(
    private val repository: AnimeRepository
) {
    operator fun invoke() : Flow<Events<List<AnimeData>>> = flow{
        try{
            emit(Events.Loading<List<AnimeData>>())
            val animeData = repository.getAnimeList().data.documents.map {
                it.toAnimeData()
            }
            emit(Events.Success<List<AnimeData>>(animeData))
        }
        catch (e: HttpException){
            emit(Events.Error<List<AnimeData>>(message = e.localizedMessage?:"An Unexpected Error Occurred"))
        }
        catch (e:IOException){
            emit(Events.Error<List<AnimeData>>(message = "Could Not Reach the server due to Internet Connection Loss"))
        }
    }
}