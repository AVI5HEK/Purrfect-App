package com.avi5hek.purrfectapp.util.scheduler

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**
 * Provides different types of schedulers specific to Android framework.
 */
class AndroidSchedulerProvider
constructor() : SchedulerProvider {

  override fun trampoline(): Scheduler {
    return Schedulers.trampoline()
  }

  override fun newThread(): Scheduler {
    return Schedulers.newThread()
  }

  override fun computation(): Scheduler {
    return Schedulers.computation()
  }

  override fun io(): Scheduler {
    return Schedulers.io()
  }

  override fun ui(): Scheduler {
    return AndroidSchedulers.mainThread()
  }
}
