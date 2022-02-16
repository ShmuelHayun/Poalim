package com.cambium.vast.poalimassignment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool
import com.cambium.vast.poalimassignment.Utils.DataUtils
import com.cambium.vast.poalimassignment.custom.obj.FavoriteItemAdapter
import com.cambium.vast.poalimassignment.custom.obj.SearchItemAdapter
import com.cambium.vast.poalimassignment.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Remove ActionBar
        getSupportActionBar()?.hide()

        //Search logic
        handleSearch()

        //Handle logic of favorites characters
        handleFavoritesCharacters()

    }

    private fun handleSearch() {
            binding.btnSearch.setOnClickListener {

                if (binding.searchEt.text.toString() != ""){

                    val heroName =  binding.searchEt.text.toString()
                    DataUtils.instance.getIdByName(heroName)

                    val handler = Handler()
                    handler.postDelayed(
                        Runnable {
                            handleAdapter(DataUtils.characterName!!,DataUtils.imageUrl!!)
                            binding.loader.visibility = View.INVISIBLE
                        },
                        5000
                    )

                    binding.loader.visibility = View.VISIBLE
                    binding.favoritesList.visibility = View.INVISIBLE
                }

            }
    }

    fun handleAdapter(names:ArrayList<String>,imageUrls:ArrayList<String>){
        var intent : Intent
        val adapter = SearchItemAdapter( this,names,imageUrls,callback =
        object : SearchItemAdapter.NameAdapterCallBack {
            override fun onNameSelected(name: String, url:String) {
                binding.searchEt.visibility = View.VISIBLE
                binding.resultRecyclerView.visibility = View.INVISIBLE
                binding.btnSearch.visibility = View.VISIBLE
                binding.favoritesList.visibility = View.VISIBLE
                binding.searchEt.setText("")

                //Init intent
                intent = Intent(baseContext,CharacterDetailsActivity::class.java)
                intent.putExtra("name",name)
                intent.putExtra("ImageUrl",url)
                startActivity(intent)
             }

          }
        )

        binding.resultRecyclerView.adapter = adapter
        binding.resultRecyclerView.layoutManager = LinearLayoutManager(this)

        binding.searchEt.visibility = View.INVISIBLE
        binding.resultRecyclerView.visibility = View.VISIBLE
        binding.btnSearch.visibility = View.INVISIBLE
    }


    private fun handleFavoritesCharacters() {
        var intent : Intent
        val favoritesCharactersNames = ArrayList<String>()
        favoritesCharactersNames.addAll(resources.getStringArray(R.array.favorites_characters_names).toList())

        val favoritesCharactersUrls = ArrayList<String>()
        favoritesCharactersUrls.add("https://www.superherodb.com/pictures2/portraits/10/100/181.jpg")
        favoritesCharactersUrls.add("https://www.superherodb.com/pictures2/portraits/10/100/1521.jpg")
        favoritesCharactersUrls.add("https://www.superherodb.com/pictures2/portraits/10/100/85.jpg")


        val adapter = FavoriteItemAdapter( this,favoritesCharactersNames,favoritesCharactersUrls,callback =
        object : FavoriteItemAdapter.FavoriteNameAdapterCallBack {

            override fun onFavoriteNameSelected(name: String,url :String) {
                //Init intent
                intent = Intent(baseContext,CharacterDetailsActivity::class.java)
                intent.putExtra("name",name)
                intent.putExtra("ImageUrl",url)
                startActivity(intent)
            }

          }
        )

        binding.favoritesList.adapter = adapter
        binding.favoritesList.layoutManager = LinearLayoutManager(this)

    }


}