package com.example.diworkshop.models.usecases.impl

import android.util.Log
import com.example.diworkshop.models.entities.anime.AnimeDetailInfo
import com.example.diworkshop.models.entities.anime.AnimeInfo
import com.example.diworkshop.models.entities.state.LoadingResult
import com.example.diworkshop.models.repositories.AnimeRepository
import com.example.diworkshop.models.usecases.LoadAnimeDetailsUseCase
import com.example.diworkshop.models.usecases.LoadAnimeListUseCase
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class LoadAnimeDetailsUseCaseImpl @Inject constructor(
    private val repository: AnimeRepository
) : LoadAnimeDetailsUseCase {

    override fun invoke(name: String): Flow<LoadingResult<AnimeDetailInfo>> {
        return flow {
            emit(LoadingResult.Processed)

            val animeList = repository.getAnimeDetailInfo(name)
            val loadingResult = LoadingResult.Success(animeList)

            emit(loadingResult)
        }.catch { throwable ->
            Log.d("LoadAnimeDetailsUseCase", "Error on loading anime detailed info", throwable)

            val loadingResult = LoadingResult.Error(throwable)
            emit(loadingResult)
        }
    }
}