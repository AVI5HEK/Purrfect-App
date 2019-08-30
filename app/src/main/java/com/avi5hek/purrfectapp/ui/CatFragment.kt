package com.avi5hek.purrfectapp.ui


import android.app.Dialog
import android.arch.lifecycle.Observer
import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AppCompatDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.avi5hek.purrfectapp.R
import com.avi5hek.purrfectapp.model.Status
import com.avi5hek.purrfectapp.util.GlideApp
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_cat.*
import javax.inject.Inject

class CatFragment : AppCompatDialogFragment() {

  @Inject
  lateinit var mainViewModel: MainViewModel

  override fun onAttach(context: Context?) {
    AndroidSupportInjection.inject(this)
    super.onAttach(context)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_cat, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    mainViewModel.catLiveData.observe(
      this, Observer { cat ->
        cat?.apply {
          when (status) {
            Status.LOADING -> {
              progress_bar.visibility = View.VISIBLE
            }
            Status.SUCCESS -> {
              progress_bar.visibility = View.GONE
              data?.url?.apply {
                GlideApp.with(image_cat_preview.context)
                  .load(this)
                  .into(image_cat_preview)
              }
            }
            Status.ERROR -> {
              progress_bar.visibility = View.GONE
            }
          }
        }
      })
    arguments?.apply {
      getString(BUNDLE_KEY_ID)?.apply {
        mainViewModel.getCatImage(this)
      }
    }
  }

  override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
    val dialog = super.onCreateDialog(savedInstanceState)
    dialog.window?.let {
      // set dialog background_tinted color to transparent
      it.setBackgroundDrawableResource(android.R.color.transparent)
    }
    return dialog
  }

  override fun onResume() {
    super.onResume()
    dialog.window?.setLayout(
      WindowManager.LayoutParams.MATCH_PARENT,
      WindowManager.LayoutParams.WRAP_CONTENT
    )
  }

  companion object {
    fun newInstance(id: String): CatFragment {
      return CatFragment().apply {
        arguments = Bundle().apply { putString(BUNDLE_KEY_ID, id) }
        setStyle(DialogFragment.STYLE_NO_TITLE, theme)
      }
    }

    const val BUNDLE_KEY_ID = "catImageId"
    val TAG: String by lazy { CatFragment::class.java.simpleName }
  }
}
