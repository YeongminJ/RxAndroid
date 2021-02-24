package com.example.myretrofit.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IRetrofit {
    @GET ("/search/photos")
    fun getPhotos(@Query("query") searchTerm: String) : Call<ResponseData>

    @GET ("/search/users")
    fun getUsers()
}