package com.example.diworkshop.ui.details.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.diworkshop.databinding.ItemAnimeFactBinding
import com.example.diworkshop.models.entities.anime.AnimeFactInfo

class AnimeFactListAdapter : RecyclerView.Adapter<AnimeFactItemHolder>() {
    private val items = mutableListOf<AnimeFactInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeFactItemHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemAnimeFactBinding.inflate(layoutInflater, parent, false)
        return AnimeFactItemHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimeFactItemHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size
}