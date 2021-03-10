package com.example.myretrofit.views

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myretrofit.R
import com.example.myretrofit.databinding.ActivityMainBinding
import com.example.myretrofit.retrofit.RetrofitManager
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.toObservable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : Activity() {
    private val TAG = "MainActivity"

    lateinit var binding : ActivityMainBinding

    var mDisposeable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        // Make Adapter
        binding.rcView.layoutManager = GridLayoutManager(this@MainActivity, 3)
        binding.rcView.adapter = PhotoAdapter()

        /*// 방법 1
        RetrofitManager.instance.searchPhoto("cat", completion = ({
                Log.i(TAG, "Search Completion: ${it?.results?.size}")
                // Make Adapter
                binding.rcView.layoutManager = GridLayoutManager(this@MainActivity, 3)
                binding.rcView.adapter = PhotoAdapter()
                //Rx Insert
                var observableArrayList = it?.results?.toObservable()
                val disposable = observableArrayList
    //                ?.observeOn(AndroidSchedulers.mainThread())
                    ?.subscribe { it ->
                        (binding.rcView.adapter as PhotoAdapter).insert(it)
                    }
                if (disposable != null)
                    mDisposeable.add(disposable!!)

            })
        )*/

        // 방법 2
        var disposable = RetrofitManager.instance.searchPhoto("cat")
            ?.subscribe ({
                it ->
                (binding.rcView.adapter as PhotoAdapter).insert(it)
            }, {

            })
        mDisposeable.add(disposable)
    }

    override fun onDestroy() {
        super.onDestroy()
        mDisposeable.clear()
    }
}