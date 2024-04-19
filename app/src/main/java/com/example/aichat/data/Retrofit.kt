package com.example.aichat.data

import com.example.aichat.data.api.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object Retrofit {

    private val okHttpClient: OkHttpClient by lazy {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.openai.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    val service = retrofit.create(ApiService::class.java)
}