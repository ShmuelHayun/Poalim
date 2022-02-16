package com.cambium.vast.poalimassignment.Utils

import com.cambium.vast.poalimassignment.Api.RestApi
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import java.lang.NullPointerException

class DataUtils {


    companion object {


        var characterId : ArrayList<Int>? = ArrayList()
        var characterName : ArrayList<String>? = ArrayList()
        var imageUrl : ArrayList<String>? = ArrayList()

        private var dataUtils : DataUtils? = null

        val instance: DataUtils
            get() {
                if (dataUtils == null)
                    dataUtils = DataUtils()

                return dataUtils!!
            }
    }

    fun getDataCharacter(id:Int){
        RestApi.create().getCharacterData(id).enqueue(object : retrofit2.Callback<ResponseBody> {
            override fun onResponse(
                call: Call<ResponseBody>,
                response: Response<ResponseBody>
            ) {
                if (response.isSuccessful){

                    val answer = JSONObject(response.body()!!.string())
                    KotLog.instance.printToLogCat("Result : $answer")

                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                KotLog.instance.printToLogCat("Error : $t")
            }

        })
    }

    fun getPowerStatsCharacter(id: Int){
        RestApi.create().getPowerStats(id).enqueue(object : retrofit2.Callback<ResponseBody> {
            override fun onResponse(
                call: Call<ResponseBody>,
                response: Response<ResponseBody>
            ) {
                if (response.isSuccessful){

                    val answer = JSONObject(response.body()!!.string())
                    KotLog.instance.printToLogCat("Result : $answer")

                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                KotLog.instance.printToLogCat("Error : $t")
            }

        })

    }


    fun getBiography(id: Int){

        RestApi.create().getCharacterBiography(id).enqueue(object : retrofit2.Callback<ResponseBody> {
            override fun onResponse(
                call: Call<ResponseBody>,
                response: Response<ResponseBody>
            ) {
                if (response.isSuccessful){

                    val answer = JSONObject(response.body()!!.string())
                    KotLog.instance.printToLogCat("Result : $answer")

                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                KotLog.instance.printToLogCat("Error : $t")
            }

        })
    }

    fun getAppearance(id:Int){
        RestApi.create().getCharacterAppearance(id).enqueue(object : retrofit2.Callback<ResponseBody> {
            override fun onResponse(
                call: Call<ResponseBody>,
                response: Response<ResponseBody>
            ) {
                if (response.isSuccessful){

                    val answer = JSONObject(response.body()!!.string())
                    KotLog.instance.printToLogCat("Result : $answer")

                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                KotLog.instance.printToLogCat("Error : $t")
            }

        })
    }

    fun getCharacterWork(id: Int){
        RestApi.create().characterWork(id).enqueue(object : retrofit2.Callback<ResponseBody> {
            override fun onResponse(
                call: Call<ResponseBody>,
                response: Response<ResponseBody>
            ) {
                if (response.isSuccessful){

                    val answer = JSONObject(response.body()!!.string())
                    KotLog.instance.printToLogCat("Result : $answer")

                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                KotLog.instance.printToLogCat("Error : $t")
            }

        })
    }


    fun getConnections(id: Int){
        RestApi.create().getCharacterConnections(id).enqueue(object : retrofit2.Callback<ResponseBody> {
            override fun onResponse(
                call: Call<ResponseBody>,
                response: Response<ResponseBody>
            ) {
                if (response.isSuccessful){

                    val answer = JSONObject(response.body()!!.string())
                    KotLog.instance.printToLogCat("Result : $answer")

                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                KotLog.instance.printToLogCat("Error : $t")
            }

        })
    }


    fun getImageUrl(id: Int){
        RestApi.create().getCharacterImage(id).enqueue(object : retrofit2.Callback<ResponseBody> {
            override fun onResponse(
                call: Call<ResponseBody>,
                response: Response<ResponseBody>
            ) {
                if (response.isSuccessful){

                    val answer = JSONObject(response.body()!!.string())
                    KotLog.instance.printToLogCat("Result : $answer")

                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                KotLog.instance.printToLogCat("Error : $t")
            }

        })
    }


    fun getIdByName(name:String){
        RestApi.create().getCharacterIdByName(name).enqueue(object : retrofit2.Callback<ResponseBody> {
            override fun onResponse(
                call: Call<ResponseBody>,
                response: Response<ResponseBody>
            ) {
                if (response.isSuccessful){
                    val jsonObject = JSONObject(response.body()!!.string())
                    val jsonArray = jsonObject.optJSONArray("results")

                    try {
                        for (i in 0 until jsonArray?.length()!!) {
                            val Object = jsonArray.getJSONObject(i)
                            characterId?.add(Object.optString("id").toInt())
                            characterName?.add(Object.optString("name").toString())
                            val url = JSONObject(Object.optString("image").toString())
                            imageUrl?.add(url.get("url").toString())
                        }
                        KotLog.instance.printToLogCat("Result : $imageUrl")

                    }catch (e: NullPointerException){
                        KotLog.instance.printToLogCat("Error : $e")
                    }

                }
            }
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                KotLog.instance.printToLogCat("Error : $t")
            }
        })
    }


}