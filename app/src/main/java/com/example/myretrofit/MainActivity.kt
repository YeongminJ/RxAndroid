package com.example.myretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myretrofit.retrofit.RetrofitClient
import com.example.myretrofit.utils.Constant.API_BASE_URL

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RetrofitClient.getClient(API_BASE_URL).apply {

        }
    }
}