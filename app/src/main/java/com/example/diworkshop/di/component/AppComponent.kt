package com.example.diworkshop.di.component

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.diworkshop.MainApplication
import com.example.diworkshop.di.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityModule::class,
        FragmentModule::class,
        ViewModelModule::class,
        NetworkModule::class,
        AnimeModule::class
    ]
)
@Singleton
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun setApplication(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(mainApplication: MainApplication)
}