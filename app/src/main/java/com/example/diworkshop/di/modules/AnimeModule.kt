package com.example.diworkshop.di.modules

import com.example.diworkshop.models.usecases.LoadAnimeListUseCase
import com.example.diworkshop.models.usecases.impl.LoadAnimeListUseCaseImpl
import com.example.diworkshop.models.usecases.impl.LoadAnimeListUseCaseImpl2
import dagger.Binds
import dagger.Module
import dagger.Provides
import java.lang.annotation.RetentionPolicy
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
interface AnimeModule {
//    companion object {
//        @Provides
//        @Singleton
//        @LoadingAnimeListOne
//        fun provideLoadAnimeListUseCase(useCase: LoadAnimeListUseCaseImpl): LoadAnimeListUseCase = useCase
//
//        @Provides
//        @Singleton
//        @LoadingAnimeListTwo
//        fun provideLoadAnimeListUse(useCase: LoadAnimeListUseCaseImpl2): LoadAnimeListUseCase = useCase
//    }

    @Binds
    fun bindLoadAnimeListUseCase(useCase: LoadAnimeListUseCaseImpl): LoadAnimeListUseCase
}

//@Qualifier
//@Retention(AnnotationRetention.RUNTIME)
//annotation class LoadingAnimeListOne
//
//@Qualifier
//@Retention(AnnotationRetention.RUNTIME)
//annotation class LoadingAnimeListTwo
