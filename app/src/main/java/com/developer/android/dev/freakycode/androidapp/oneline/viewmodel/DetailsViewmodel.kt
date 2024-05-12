package com.developer.android.dev.freakycode.androidapp.oneline.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developer.android.dev.freakycode.androidapp.oneline.models.TweetListItem
import com.developer.android.dev.freakycode.androidapp.oneline.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewmodel @Inject constructor(private val tweetRepository: TweetRepository) :ViewModel() {

    val tweets:StateFlow<List<TweetListItem>> get() = tweetRepository.tweets

    init {
        viewModelScope.launch {
            tweetRepository.getTweets("Android")
        }
    }
}