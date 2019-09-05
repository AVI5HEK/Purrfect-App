package com.avi5hek.purrfectapp.ui

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.avi5hek.purrfectapp.R
import com.avi5hek.purrfectapp.model.Cat
import com.avi5hek.purrfectapp.model.Status
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasAndroidInjector {

  @Inject
  lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

  override fun androidInjector(): AndroidInjector<Any> {
    return dispatchingAndroidInjector
  }

  @Inject
  lateinit var mainViewModel: MainViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    mainViewModel.catsLiveData.observe(
      this,
      Observer { cats ->
        cats?.also {
          when (it.status) {
            Status.LOADING -> {
              progress_bar.visibility = View.VISIBLE
            }
            Status.SUCCESS -> {
              progress_bar.visibility = View.GONE
              it.data?.apply { displayCats(this) }
            }
            Status.ERROR -> {
              progress_bar.visibility = View.GONE
            }
          }
        }
      })
  }

  private fun displayCats(cats: List<Cat>) {
    recycler_cats.apply {
      layoutManager = LinearLayoutManager(this@MainActivity)
      adapter = CatListAdapter(cats) {
        Log.d(javaClass.simpleName, "Clicked cat with id: $it")
        CatFragment.newInstance(it).show(supportFragmentManager, CatFragment.TAG)
      }
    }
  }
}
