package com.example.aichat.data.api

import com.example.aichat.data.model.ChatGptRequest
import com.example.aichat.data.model.ResponseResult
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {

    @POST("v1/chat/completions")
    suspend fun createChatGpt(
        @Header("Content-Type") type : String,
        @Header("Authorization") apiKey: String,
        @Body request: ChatGptRequest
    ): Response<ResponseResult>


}