package com.example.diworkshop.ui.details

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.diworkshop.R
import com.example.diworkshop.databinding.FragmentAnimeDetailBinding
import com.example.diworkshop.di.utils.ViewModelFactory
import com.example.diworkshop.models.entities.anime.AnimeDetailInfo
import com.example.diworkshop.models.entities.state.LoadingResult
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject
import android.R




class AnimeDetailsFragment @Inject constructor(
    viewModelFactory: ViewModelFactory
) : Fragment(R.layout.fragment_anime_detail) {

    private var _binding: FragmentAnimeDetailBinding? = null
    private val binding get() = _binding!!
    private var animeName : String? = null
    private val viewModel: AnimeDetailViewModel by viewModels { viewModelFactory}



    /*private val factListAdapter: AnimeFactListAdapter by lazy {
        AnimeFactListAdapter()
    }*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAnimeDetailBinding.bind(view)
        var bundle1 = getArguments();
        animeName =  bundle1?.getString("animeName")
        viewModel.animeName = animeName.toString()
        viewModel.loadResultFun()

        binding.textView.text = animeName
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
        Log.d("AnimeDetailFragment", "ЗАГРУЗКА")
        binding.progressIndicator.visibility = View.VISIBLE
    }

    private fun onSuccess(anime: AnimeDetailInfo) {
        Log.d("AnimeDetailFragment", "УСПЕХ")

        binding.textView.text = anime.data[1].toString()

        Glide.with(getView()).load(anime.image).into(binding.image);

        binding.progressIndicator.visibility = View.GONE
    }

    private fun onError(throwable: Throwable) {
        Log.d("AnimeDetailFragment", "ОШИБКА", throwable)
        binding.progressIndicator.visibility = View.GONE

        Snackbar.make(binding.root, "ОШИБКА", Snackbar.LENGTH_SHORT).show()
    }
}