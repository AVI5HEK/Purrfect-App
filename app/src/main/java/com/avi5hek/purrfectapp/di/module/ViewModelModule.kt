package com.avi5hek.purrfectapp.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.avi5hek.purrfectapp.di.ViewModelKey
import com.avi5hek.purrfectapp.ui.MainViewModel
import com.avi5hek.purrfectapp.ui.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by "Avishek" on 8/22/2019.
 */
@Module
abstract class ViewModelModule {

  @Binds
  @IntoMap
  @ViewModelKey(MainViewModel::class)
  abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

  @Binds
  abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}
