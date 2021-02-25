package com.example.myretrofit.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myretrofit.R

class PhotoAdapter : RecyclerView.Adapter<PhotoAdapter.PhotoHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.photo_item, null, false)
        return PhotoHolder(itemView)
    }

    override fun getItemCount(): Int {
        return 0
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        
    }

    class PhotoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}