package com.avi5hek.purrfectapp.di.module

import com.avi5hek.purrfectapp.di.scope.ActivityScope
import com.avi5hek.purrfectapp.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by "Avishek" on 8/19/2019.
 */
@Module
abstract class ActivityBindingModule {

  @ActivityScope
  @ContributesAndroidInjector
  abstract fun contributeMainActivity(): MainActivity
}
