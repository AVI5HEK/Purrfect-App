package com.avi5hek.purrfectapp.di.module

import com.avi5hek.purrfectapp.ui.CatFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by "Avishek" on 8/20/2019.
 */
@Module
abstract class FragmentBindingModule {

  @ContributesAndroidInjector
  abstract fun contributeCatFragment(): CatFragment
}
