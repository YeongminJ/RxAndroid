package com.tnfg.mvvm.api

import android.util.Log
import com.tnfg.mvvm.model.ResponseData
import com.tnfg.mvvm.utils.Constant
import io.reactivex.rxjava3.core.Single
import retrofit2.Response

class RetrofitManager {

    val TAG = "RetrofitManager"

    companion object {
        var instance = RetrofitManager()
    }

    val iRetrofit = RetrofitClient.getClient(Constant.API_BASE_URL).create(IRetrofit::class.java)

    fun searchPhoto(searchTerm: String, completion: (ResponseData?) -> Unit) {
        var call = iRetrofit.getPhotos(searchTerm)
        call.enqueue(object: retrofit2.Callback<ResponseData> {
            override fun onFailure(call: retrofit2.Call<ResponseData>, t: Throwable) {
                Log.d(TAG, "onFailure: callBack")
            }

            override fun onResponse(call: retrofit2.Call<ResponseData>, response: Response<ResponseData>) {
                Log.d(TAG, "onResponse: ${response.body()}")
                completion(response.body())
            }
        })
    }

    fun searchPhoto(searchTerm: String) : Single<ResponseData> {
        return iRetrofit.getObserablePhoto(searchTerm)
    }
}