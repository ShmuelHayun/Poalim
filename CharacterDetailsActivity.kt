package com.cambium.vast.poalimassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.cambium.vast.poalimassignment.Utils.DataUtils
import com.cambium.vast.poalimassignment.Utils.KotLog
import com.cambium.vast.poalimassignment.databinding.ActivityCharacterDetailsBinding


class CharacterDetailsActivity : AppCompatActivity() {

    private lateinit var bindingDetails: ActivityCharacterDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingDetails = ActivityCharacterDetailsBinding.inflate(layoutInflater)
        setContentView(bindingDetails.root)
        //Remove ActionBar
        getSupportActionBar()?.hide()

        handleData()

    }

    private fun handleData() {
        val bundle: Bundle? = intent.extras
        val name: String? = bundle?.getString("name")
        val url: String? = bundle?.getString("ImageUrl")

        Glide.with(this)
            .load(url)
            .into(bindingDetails.characterImage)

        bindingDetails.tvNameCharacter.setText(name)
        KotLog.instance.printToLogCat("Name : $name Url : $url")
    }
}