package com.cambium.vast.poalimassignment.custom.obj

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cambium.vast.poalimassignment.databinding.FavoriteListItemBinding


class FavoriteItemAdapter (var context: Activity, var name: ArrayList<String>, var url: ArrayList<String>, var callback : FavoriteNameAdapterCallBack)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var binding: FavoriteListItemBinding? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        binding = FavoriteListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)

        return FavoriteNameViewHolder(binding!!)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        binding?.favoriteCharacterNameTv?.text = name.get(position)

        binding?.favoriteCharacterNameTv?.setOnClickListener {
            callback.onFavoriteNameSelected(name.get(position),url.get(position))

        }
    }

    override fun getItemCount(): Int {
        return name.size
    }

    // ViewHolder
    class FavoriteNameViewHolder(binding: FavoriteListItemBinding) : RecyclerView.ViewHolder(binding.root)

    interface FavoriteNameAdapterCallBack{
        fun onFavoriteNameSelected(name : String,url : String)
    }

}