package com.example.diworkshop.ui.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.diworkshop.databinding.ItemAnimeListBinding
import com.example.diworkshop.models.entities.anime.AnimeInfo

class AnimeListAdapter(
    private val animeItemClickListener: AnimeItemClickListener
) : RecyclerView.Adapter<AnimeListItemHolder>() {
    private val items = mutableListOf<AnimeInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeListItemHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemAnimeListBinding.inflate(layoutInflater, parent, false)
        return AnimeListItemHolder(binding, animeItemClickListener)
    }

    override fun onBindViewHolder(holder: AnimeListItemHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    fun updateData(newItems: List<AnimeInfo>) {
        items.apply {
            clear()
            addAll(newItems)
        }

        notifyDataSetChanged()
    }

    fun interface AnimeItemClickListener {
        fun onClick(animeInfo: AnimeInfo)
    }
}