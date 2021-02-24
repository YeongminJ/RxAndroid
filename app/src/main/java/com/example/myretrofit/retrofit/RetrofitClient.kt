package com.example.myretrofit.retrofit

import android.util.Log
import com.example.myretrofit.utils.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//싱글톤
object RetrofitClient {

    private val TAG = "RetrofitClient"

    private var retrofitClient: Retrofit? = null

    //get Client
    fun getClient(baseUrl: String): Retrofit? {
        Log.d(TAG, "getClient: called()")
        if (retrofitClient == null) {
            retrofitClient = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofitClient
    }
}