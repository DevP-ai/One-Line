package com.developer.android.dev.freakycode.androidapp.oneline.repository

import com.developer.android.dev.freakycode.androidapp.oneline.api.TweetsAPI
import com.developer.android.dev.freakycode.androidapp.oneline.models.TweetListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetRepository @Inject constructor(private val tweetsAPI: TweetsAPI){

    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories :StateFlow<List<String>> get() = _categories


    private val _tweets = MutableStateFlow<List<TweetListItem>>(emptyList())
    val tweets :StateFlow<List<TweetListItem>> get() = _tweets


    suspend fun getCategory(){
        val response = tweetsAPI.getCategory()

        if(response.isSuccessful && response.body()!=null){
            _categories.emit(response.body()!!)
        }
    }


    suspend fun getTweets(category:String){
        val response = tweetsAPI.getTweets("tweets[?(@.category==\"${category}\")]")

        if(response.isSuccessful && response.body()!=null){
            _tweets.emit(response.body()!!)
        }
    }
}