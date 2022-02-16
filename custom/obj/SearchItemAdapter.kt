package com.cambium.vast.poalimassignment.custom.obj

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cambium.vast.poalimassignment.databinding.SearchListItemBinding



class SearchItemAdapter (var context: Activity, var name: ArrayList<String>,  var imgUrl: ArrayList<String>,var callback : NameAdapterCallBack)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private var binding: SearchListItemBinding? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = SearchListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)

        return NameViewHolder(binding!!)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        binding?.characterNameTv?.text = name.get(position)
            //Load characters images
            Glide.with(context)
                .load(imgUrl.get(position))
                .into(binding?.characterImage!!)

                    binding?.characterNameTv?.setOnClickListener {
                callback.onNameSelected(name.get(position),imgUrl.get(position))

        }
    }

    override fun getItemCount(): Int {
        return name.size
    }

    // ViewHolder
    class NameViewHolder(binding: SearchListItemBinding) : RecyclerView.ViewHolder(binding.root)

    interface NameAdapterCallBack{
        fun onNameSelected(name : String,url:String)
    }

}