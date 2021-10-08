package com.example.diworkshop.ui.list

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diworkshop.R
import com.example.diworkshop.databinding.FragmentAnimeListBinding
import com.example.diworkshop.di.utils.ViewModelFactory
import com.example.diworkshop.models.entities.anime.AnimeInfo
import com.example.diworkshop.models.entities.state.LoadingResult
import com.example.diworkshop.ui.list.adapter.AnimeListAdapter
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

class AnimeListFragment @Inject constructor(
    viewModelFactory: ViewModelFactory
) : Fragment(R.layout.fragment_anime_list) {

    private var _binding: FragmentAnimeListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AnimeListViewModel by viewModels { viewModelFactory }

    private val animeItemClickListener: AnimeListAdapter.AnimeItemClickListener by lazy {
        AnimeListAdapter.AnimeItemClickListener { animeInfo ->
            val direction = AnimeListFragmentDirections.toDetail(animeInfo.name)
            findNavController().navigate(direction)
        }
    }

    private val animeListAdapter: AnimeListAdapter by lazy {
        AnimeListAdapter(animeItemClickListener)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAnimeListBinding.bind(view)

        binding.animeList.apply {
            adapter = animeListAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onResume() {
        super.onResume()

        viewModel.loadResult.observe(viewLifecycleOwner) { loadingResult ->
            when(loadingResult) {
                is LoadingResult.Processed -> onProcessing()
                is LoadingResult.Success -> onSuccess(loadingResult.data)
                is LoadingResult.Error -> onError(loadingResult.exception)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onProcessing() {
        Log.d("AnimeListFragment", "ЗАГРУЗКА")
        binding.progressIndicator.visibility = View.VISIBLE
    }

    private fun onSuccess(animeList: List<AnimeInfo>) {
        Log.d("AnimeListFragment", "УСПЕХ")
        animeListAdapter.updateData(animeList)
        binding.progressIndicator.visibility = View.GONE
    }

    private fun onError(throwable: Throwable) {
        Log.d("AnimeListFragment", "ОШИБКА", throwable)
        binding.progressIndicator.visibility = View.GONE

        Snackbar.make(binding.root, "ОШИБКА", Snackbar.LENGTH_SHORT).show()
    }
}