package com.example.myretrofit.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.myretrofit.R
import com.example.myretrofit.databinding.ActivityMainBinding
import com.example.myretrofit.retrofit.IRetrofit
import com.example.myretrofit.retrofit.ResponseData
import com.example.myretrofit.retrofit.RetrofitClient
import com.example.myretrofit.utils.Constant.API_BASE_URL
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        
        

        RetrofitClient.getClient(API_BASE_URL).apply {
            var gitService = this?.create(IRetrofit::class.java)
            var call = gitService?.getPhotos("cat")
            call?.enqueue(object : Callback<ResponseData> {
                override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                    Log.d(TAG, "onFailure: ")
                }

                override fun onResponse(call: Call<ResponseData>, response: Response<ResponseData>) {
                    Log.d(TAG, "onResponse: ${response.body().toString()}")
                }
            })

            var userCall = gitService?.getUsers("doodoon87")
            userCall?.enqueue(object: Callback<JsonElement> {
                override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                    Log.d(TAG, "onFailure: userCall")
                }

                override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                    Log.d(TAG, "onResponse: userCall, ${response.body()}")
                }

            })
        }
    }
}