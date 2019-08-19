package com.avi5hek.purrfectapp.di

import com.avi5hek.purrfectapp.PurrfectApp
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Created by "Avishek" on 8/19/2019.
 */
@Component(
  modules = [
    AndroidSupportInjectionModule::class
  ]
)
interface AppComponent : AndroidInjector<PurrfectApp>
