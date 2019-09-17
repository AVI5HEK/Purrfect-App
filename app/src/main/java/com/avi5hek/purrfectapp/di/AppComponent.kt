package com.avi5hek.purrfectapp.di

import com.avi5hek.purrfectapp.PurrfectApp
import com.avi5hek.purrfectapp.di.module.*
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
    AppModule::class,
    ViewModelModule::class,
    FragmentBindingModule::class
  ]
)
interface AppComponent : AndroidInjector<PurrfectApp>
