package com.example.myretrofit.retrofit

import android.util.Log
import com.example.myretrofit.utils.Constant
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

//싱글톤
object RetrofitClient {

    private val TAG = "RetrofitClient"

    private var retrofitClient: Retrofit? = null

    //get Client
    fun getClient(baseUrl: String): Retrofit? {
        Log.d(TAG, "getClient: called()")

        //OKHttp Client 생성
        val okClient = OkHttpClient.Builder()

        //로깅 인터셉터 생성
        val loggingInterceptor = HttpLoggingInterceptor(object: HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Log.v(TAG, "log: / message : $message")
            }
        })

        // 로깅 인터셉터 추가
        okClient.addInterceptor(loggingInterceptor)

        // 기본 파라매터 인터셉터 추가
        val baseParameterInterceptor : Interceptor = (object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                Log.d(TAG, "interceptCalled")
                val originRequest = chain.request()

                //쿼리 파라매터 추가하기
                val addedUrl = originRequest.url.newBuilder().addQueryParameter("client_id", Constant.API_ACCESS_KEY).build()

                val finalRequest = originRequest.newBuilder()
                    .url(addedUrl)
                    .method(originRequest.method, originRequest.body)
                    .build()

                return chain.proceed(finalRequest)
            }
        })
        //적용
        okClient.addInterceptor(baseParameterInterceptor)

        if (retrofitClient == null) {
            retrofitClient = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create()) //data 변환
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())  //Rx Single or Obserable 반환 하기 위
                .client(okClient.build())
                .build()
        }
        return retrofitClient
    }
}