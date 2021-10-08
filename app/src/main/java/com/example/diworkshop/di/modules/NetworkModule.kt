package com.example.diworkshop.di.modules

import com.example.diworkshop.sources.api.AnimeService
import com.example.diworkshop.utils.AnimeServiceBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideAnimeService(): AnimeService = AnimeServiceBuilder().build()
}