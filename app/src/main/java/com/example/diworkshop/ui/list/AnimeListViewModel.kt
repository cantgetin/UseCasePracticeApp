package com.example.diworkshop.ui.list

import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import javax.inject.Inject

class AnimeListViewModel @Inject constructor(

) : ViewModel() {

    fun getNavDirection(animeName: String): NavDirections {
        return AnimeListFragmentDirections.toDetail(animeName)
    }
}