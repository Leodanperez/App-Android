package com.leo.miprimeraapp.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.leo.miprimeraapp.databinding.ItemLayoutBinding
import com.leo.miprimeraapp.models.Hit
import com.squareup.picasso.Picasso

class ImageViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemLayoutBinding.bind(view)

    fun bind(image: Hit) {
        Picasso.get().load(image.largeImageURL).into(binding.image)
    }
}