package com.cambium.vast.poalimassignment.Api

import com.cambium.vast.poalimassignment.databinding.ActivityMainBinding
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import com.google.gson.JsonObject

interface RestApi {

    //Get character data
    @GET("{id}")
    fun getCharacterData(@Path("id")  characterId: Int) : Call<ResponseBody>

    //Get character powerStats
    @GET("{id}/powerstats")
    fun getPowerStats(@Path("id")  characterId: Int) : Call<ResponseBody>

    //Get character biography
    @GET("{id}/biography")
    fun getCharacterBiography(@Path("id")  characterId: Int) : Call<ResponseBody>

    //Get character appearance
    @GET("{id}/appearance")
    fun getCharacterAppearance(@Path("id")  characterId: Int) : Call<ResponseBody>

    //Get character work
    @GET("{id}/work")
    fun characterWork(@Path("id")  characterId: Int) : Call<ResponseBody>

    //Get character connections
    @GET("{id}/connections")
    fun getCharacterConnections(@Path("id")  characterId: Int) : Call<ResponseBody>

    //Get character image
    @GET("{id}/image")
    fun getCharacterImage(@Path("id")  characterId: Int) : Call<ResponseBody>

    //Get character id by name
    @GET("search/{name}")
    fun getCharacterIdByName(@Path("name")  characterName: String) : Call<ResponseBody>


    companion object {

        var TOKEN :String = "10159869502921382"

        var BASE_URL = "https://superheroapi.com/api/".plus(TOKEN).plus("/")

        fun create() : RestApi {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(RestApi::class.java)

        }
    }

}