package com.developer.android.dev.freakycode.androidapp.oneline.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developer.android.dev.freakycode.androidapp.oneline.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewmodel @Inject constructor(private val tweetRepository: TweetRepository) :ViewModel() {

    val category:StateFlow<List<String>> get() = tweetRepository.categories

    init {
        viewModelScope.launch {
            tweetRepository.getCategory()
        }
    }
}