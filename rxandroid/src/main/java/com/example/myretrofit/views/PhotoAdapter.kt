package com.example.myretrofit.views

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myretrofit.databinding.PhotoItemBinding
import com.example.myretrofit.retrofit.PhotoData
import com.example.myretrofit.retrofit.ResponseData

class PhotoAdapter() : RecyclerView.Adapter<PhotoAdapter.PhotoHolder>() {

    var itemList = mutableListOf<PhotoData>()

    private val TAG = "PhotoAdapter"
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
        val binding = PhotoItemBinding.inflate(LayoutInflater.from(parent.context), null, false)
//        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.photo_item, null, false)
        return PhotoHolder(binding)
    }

    override fun getItemCount(): Int {
        Log.d(TAG, "getItemCount: ${itemList.size}")
        return itemList.size
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: $position")
        itemList[position].let { holder.bind(it) }
    }

    fun insert(item: PhotoData) {
        itemList.add(item)
        notifyItemInserted(itemList.size-1)
    }

    fun insert(item: ResponseData) {
        itemList.addAll(item.results)
        notifyItemInserted(itemList.size-1)
    }

    inner class PhotoHolder(var binding: PhotoItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: PhotoData) {
            Log.d(TAG, "bind url Data: ${data.urls.regular}")
            Log.i(TAG, "bind: Text: ${data.description}")
            Glide.with(binding.root.context).load(data.urls.regular).into(binding.photoImage)
        }
    }
}