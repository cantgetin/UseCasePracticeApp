package com.example.diworkshop.ui.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diworkshop.R
import com.example.diworkshop.databinding.FragmentAnimeDetailBinding
import com.example.diworkshop.di.utils.ViewModelFactory
import com.example.diworkshop.ui.details.adapter.AnimeFactListAdapter
import com.example.diworkshop.ui.list.AnimeListViewModel
import javax.inject.Inject

class AnimeDetailsFragment @Inject constructor(
    viewModelFactory: ViewModelFactory
) : Fragment(R.layout.fragment_anime_detail) {

    private var _binding: FragmentAnimeDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AnimeListViewModel by viewModels { viewModelFactory }

    private val factListAdapter: AnimeFactListAdapter by lazy {
        AnimeFactListAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAnimeDetailBinding.bind(view)

        binding.facts.apply {
            adapter = factListAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}