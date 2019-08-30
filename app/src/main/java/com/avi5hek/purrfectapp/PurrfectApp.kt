package com.avi5hek.purrfectapp

import android.app.Application
import com.avi5hek.purrfectapp.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 * Created by "Avishek" on 8/19/2019.
 */
class PurrfectApp : Application(), HasAndroidInjector {

  @Inject
  lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

  override fun androidInjector(): AndroidInjector<Any> {
    return dispatchingAndroidInjector
  }

  override fun onCreate() {
    DaggerAppComponent.create().inject(this)
    super.onCreate()
  }
}
