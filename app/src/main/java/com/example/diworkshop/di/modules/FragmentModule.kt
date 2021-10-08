package com.example.diworkshop.di.modules

import androidx.fragment.app.Fragment
import com.example.diworkshop.di.utils.FragmentKey
import com.example.diworkshop.ui.details.AnimeDetailsFragment
import com.example.diworkshop.ui.list.AnimeListFragment
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface FragmentModule {
    @Binds
    @IntoMap
    @FragmentKey(AnimeListFragment::class)
    fun bindAnimeListFragment(fragment: AnimeListFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(AnimeDetailsFragment::class)
    fun bindAnimeDetailsFragment(fragment: AnimeDetailsFragment): Fragment
}