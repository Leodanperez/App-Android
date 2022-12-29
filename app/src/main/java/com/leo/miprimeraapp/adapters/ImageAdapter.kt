package com.leo.miprimeraapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leo.miprimeraapp.R
import com.leo.miprimeraapp.models.Hit

class ImageAdapter(private val images: List<Hit>): RecyclerView.Adapter<ImageViewHolder>() {

    private lateinit var contextTwo: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ImageViewHolder(layoutInflater.inflate(R.layout.item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val item = images[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {  }
    }

    override fun getItemCount(): Int = images.size
}