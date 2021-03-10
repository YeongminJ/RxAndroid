package com.tnfg.mvvm.api

import com.google.gson.JsonElement
import com.tnfg.mvvm.model.ResponseData
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface IRetrofit {
    @Headers ("Authorization: Client-ID ONxhQCASxHG1YmAY2Ln5LQ0oxDsrU6IPp8H-kFAs_BM")
    @GET ("/search/photos")
    fun getPhotos(@Query("query") searchTerm: String) : Call<ResponseData>

    @GET ("/search/photos")
    fun getObserablePhoto(@Query("query") searchTerm: String) : Single<ResponseData>

    @Headers ("Authorization: Client-ID ONxhQCASxHG1YmAY2Ln5LQ0oxDsrU6IPp8H-kFAs_BM")
    @GET ("/search/users")
    fun getUsers(@Query("query") searchTerm: String) : Call<JsonElement>
}