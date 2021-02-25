package com.example.myretrofit.views

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myretrofit.R
import com.example.myretrofit.databinding.PhotoItemBinding
import com.example.myretrofit.retrofit.PhotoData

class PhotoAdapter(var results: MutableList<PhotoData>?) : RecyclerView.Adapter<PhotoAdapter.PhotoHolder>() {

    private val TAG = "PhotoAdapter"
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
        var binding = PhotoItemBinding.inflate(LayoutInflater.from(parent.context), null, false)
//        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.photo_item, null, false)
        return PhotoHolder(binding)
    }

    override fun getItemCount(): Int {
        Log.d(TAG, "getItemCount: ${results?.size}")
        return results?.size ?: 0
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: $position")
        results?.get(position)?.let { holder.bind(it) }
    }

    inner class PhotoHolder(var binding: PhotoItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: PhotoData) {
            Log.d(TAG, "bind url Data: ${data.urls.regular}")
            Glide.with(binding.root.context).load(data.urls.regular).into(binding.photoImage)
        }

    }
}