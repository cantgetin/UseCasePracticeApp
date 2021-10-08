package com.example.diworkshop.di.modules

import androidx.lifecycle.ViewModel
import com.example.diworkshop.di.utils.ViewModelKey
import com.example.diworkshop.ui.details.AnimeDetailViewModel
import com.example.diworkshop.ui.list.AnimeListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(AnimeListViewModel::class)
    fun bindAnimeListViewModel(viewModel: AnimeListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AnimeDetailViewModel::class)
    fun bindAnimeDetailViewModel(viewModel: AnimeDetailViewModel): ViewModel
}