package com.example.diworkshop.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.diworkshop.models.usecases.LoadAnimeListUseCase
import javax.inject.Inject

class AnimeListViewModel @Inject constructor(
    private val useCase: LoadAnimeListUseCase
) : ViewModel() {

    val loadResult = useCase()
        .asLiveData()
}