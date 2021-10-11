package com.example.diworkshop.ui.details

import androidx.lifecycle.ViewModel
import com.example.diworkshop.models.entities.anime.AnimeDetailInfo
import com.example.diworkshop.models.entities.state.LoadingResult
import com.example.diworkshop.models.usecases.LoadAnimeDetailsUseCase
import com.example.diworkshop.models.usecases.LoadAnimeListUseCase
import kotlinx.coroutines.flow.Flow
import androidx.lifecycle.asLiveData
import javax.inject.Inject

class AnimeDetailViewModel  @Inject constructor(
    private val useCase: LoadAnimeDetailsUseCase
) : ViewModel() {

    var animeName: String = "jujutsu_kaisen"
    var loadResult = useCase(animeName).asLiveData()

    fun loadResultFun()
    {
        loadResult = useCase(animeName).asLiveData()
    }

}