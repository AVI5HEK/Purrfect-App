package com.avi5hek.purrfectapp.di

import com.avi5hek.purrfectapp.PurrfectApp
import com.avi5hek.purrfectapp.di.module.ActivityBindingModule
import com.avi5hek.purrfectapp.di.module.AppModule
import com.avi5hek.purrfectapp.di.module.CatModule
import com.avi5hek.purrfectapp.di.module.NetworkModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by "Avishek" on 8/19/2019.
 */
@Singleton
@Component(
  modules = [
    AndroidSupportInjectionModule::class,
    ActivityBindingModule::class,
    CatModule::class,
    NetworkModule::class,
    AppModule::class
  ]
)
interface AppComponent : AndroidInjector<PurrfectApp>
