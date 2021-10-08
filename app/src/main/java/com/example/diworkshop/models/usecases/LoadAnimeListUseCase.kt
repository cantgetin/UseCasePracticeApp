package com.example.diworkshop.models.usecases

import com.example.diworkshop.models.entities.anime.AnimeInfo
import com.example.diworkshop.models.entities.state.LoadingResult
import kotlinx.coroutines.flow.Flow

interface LoadAnimeListUseCase {
    operator fun invoke(): Flow<LoadingResult<List<AnimeInfo>>>
}