package com.example.assignment4_angelsamora_ragirzebari.API

import com.example.assignment4_angelsamora_ragirzebari.DataAPIItem
import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {
    @GET("posts")
    fun getAPIData(): Call<List<DataAPIItem>>
}