package com.jramirez.pruebanapoleon.service

import com.google.gson.GsonBuilder
import com.jramirez.pruebanapoleon.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val client = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .build()
        .create(JSONPlaceholderAPI::class.java)
}