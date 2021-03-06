package com.example.diworkshop

import android.app.Application
import com.example.diworkshop.di.component.AppComponent
import com.example.diworkshop.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var hasAndroidInjector: DispatchingAndroidInjector<Any>

    private val appComponent: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .setApplication(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> = hasAndroidInjector
}