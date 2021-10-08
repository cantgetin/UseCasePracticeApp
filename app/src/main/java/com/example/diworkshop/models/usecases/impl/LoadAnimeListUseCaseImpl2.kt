package com.example.diworkshop.models.usecases.impl

import com.example.diworkshop.models.entities.anime.AnimeInfo
import com.example.diworkshop.models.entities.state.LoadingResult
import com.example.diworkshop.models.usecases.LoadAnimeListUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoadAnimeListUseCaseImpl2 @Inject constructor(

) : LoadAnimeListUseCase {
    override fun invoke(): Flow<LoadingResult<List<AnimeInfo>>> {
        return flow {

        }
    }
}