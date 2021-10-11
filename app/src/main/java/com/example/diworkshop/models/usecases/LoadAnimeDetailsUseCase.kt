package com.example.diworkshop.models.usecases

import com.example.diworkshop.models.entities.anime.AnimeDetailInfo
import com.example.diworkshop.models.entities.anime.AnimeInfo
import com.example.diworkshop.models.entities.state.LoadingResult
import dagger.Provides
import kotlinx.coroutines.flow.Flow

interface LoadAnimeDetailsUseCase {
    operator fun invoke(name: String): Flow<LoadingResult<AnimeDetailInfo>>
}