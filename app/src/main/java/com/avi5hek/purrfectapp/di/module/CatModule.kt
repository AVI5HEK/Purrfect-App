package com.avi5hek.purrfectapp.di.module

import com.avi5hek.purrfectapp.repository.CatDataRepository
import com.avi5hek.purrfectapp.repository.CatRepository
import com.avi5hek.purrfectapp.service.CatService
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by "Avishek" on 8/20/2019.
 */
@Module
abstract class CatModule {

  @Binds
  abstract fun bindCatRepository(catDataRepository: CatDataRepository): CatRepository

  @Module
  companion object {

    @JvmStatic
    @Provides
    fun provideCatService(retrofit: Retrofit): CatService {
      return retrofit.create(CatService::class.java)
    }
  }
}
