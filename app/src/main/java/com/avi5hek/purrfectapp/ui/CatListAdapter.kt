package com.avi5hek.purrfectapp.ui

import android.graphics.drawable.ColorDrawable
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.avi5hek.purrfectapp.R
import com.avi5hek.purrfectapp.model.Cat
import com.avi5hek.purrfectapp.util.GlideApp
import kotlinx.android.synthetic.main.item_cat.view.*

/**
 * Created by "Avishek" on 8/19/2019.
 */

class CatListAdapter(private val items: List<Cat>, private val onClick: (url: String) -> Unit) :
  RecyclerView.Adapter<CatListAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context.applicationContext)
      .inflate(R.layout.item_cat, parent, false)
    return ViewHolder(view)
  }

  override fun getItemCount(): Int {
    return items.size
  }

  override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
    viewHolder.bind(items[position])
  }

  inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    init {
      itemView.setOnClickListener { onClick.invoke(items[adapterPosition].id) }
    }

    fun bind(cat: Cat) {
      GlideApp.with(itemView.context.applicationContext)
        .load(cat.url)
        .placeholder(
          ColorDrawable(
            ContextCompat.getColor(
              itemView.context.applicationContext,
              R.color.imagePlaceholder
            )
          )
        )
        .into(itemView.image_cat)
    }
  }
}
