package com.avi5hek.purrfectapp.di.module

import com.avi5hek.purrfectapp.util.scheduler.AndroidSchedulerProvider
import com.avi5hek.purrfectapp.util.scheduler.SchedulerProvider
import dagger.Binds
import dagger.Module

/**
 * Created by "Avishek" on 8/20/2019.
 */
@Module
abstract class AppModule {

  @Binds
  abstract fun bindSchedulerProvider(androidSchedulerProvider: AndroidSchedulerProvider): SchedulerProvider
}
