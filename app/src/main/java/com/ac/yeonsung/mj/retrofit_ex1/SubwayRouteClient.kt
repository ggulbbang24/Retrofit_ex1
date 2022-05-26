package com.ac.yeonsung.mj.retrofit_ex1

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object SubwayRouteClient {
    private var instance : Retrofit? = null

    val gson : Gson = GsonBuilder()
        .setLenient()
        .create()

    fun getInstnace() : Retrofit {

        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

        if(instance == null){
            instance = Retrofit.Builder()
                .baseUrl("http://openapi.kric.go.kr/openapi/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build()
        }
        return instance!!
    }
}