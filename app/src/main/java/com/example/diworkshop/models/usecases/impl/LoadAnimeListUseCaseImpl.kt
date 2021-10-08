package com.example.diworkshop.models.usecases.impl

import android.util.Log
import com.example.diworkshop.models.entities.anime.AnimeInfo
import com.example.diworkshop.models.entities.state.LoadingResult
import com.example.diworkshop.models.repositories.AnimeRepository
import com.example.diworkshop.models.usecases.LoadAnimeListUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoadAnimeListUseCaseImpl @Inject constructor(
    private val repository: AnimeRepository
) : LoadAnimeListUseCase {

    override fun invoke(): Flow<LoadingResult<List<AnimeInfo>>> {
        return flow {
            emit(LoadingResult.Processed)

            val animeList = repository.getAnimeList()
            val loadingResult = LoadingResult.Success(animeList)

            emit(loadingResult)
        }.catch { throwable ->
            Log.d("LoadAnimeListUseCase", "Error on loading anime list", throwable)

            val loadingResult = LoadingResult.Error(throwable)
            emit(loadingResult)
        }
    }
}