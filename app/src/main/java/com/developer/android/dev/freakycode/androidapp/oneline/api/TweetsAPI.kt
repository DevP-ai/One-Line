package com.developer.android.dev.freakycode.androidapp.oneline.api

import com.developer.android.dev.freakycode.androidapp.oneline.models.TweetListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsAPI {

    @GET("/v3/b/6640839de41b4d34e4f27d16?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path")category:String):Response<List<TweetListItem>>

    @GET("/v3/b/6640839de41b4d34e4f27d16?meta=false")
    @Headers("X-JSON-Path:tweets..category")
    suspend fun getCategory():Response<List<String>>
}