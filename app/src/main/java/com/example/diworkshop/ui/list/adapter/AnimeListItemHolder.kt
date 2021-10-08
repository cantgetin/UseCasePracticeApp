package com.example.diworkshop.ui.list.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.diworkshop.databinding.ItemAnimeListBinding
import com.example.diworkshop.models.entities.anime.AnimeInfo

class AnimeListItemHolder(
    private val binding: ItemAnimeListBinding,
    private val animeItemClickListener: AnimeListAdapter.AnimeItemClickListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(animeInfo: AnimeInfo) {
        binding.name.text = animeInfo.name
        binding.image.load(animeInfo.image)

        binding.root.setOnClickListener {
            animeItemClickListener.onClick(animeInfo)
        }
    }
}