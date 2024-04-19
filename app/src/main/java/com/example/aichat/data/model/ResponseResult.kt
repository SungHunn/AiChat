package com.example.aichat.data.model

import com.google.gson.annotations.SerializedName

data class ResponseResult(
    val id: String,
    @SerializedName("object")
    val obj: String,
    val created: Int,
    val model: String,
    val system_fingerprint: String,
    val choices: List<Choice>,
    val usage: Usage

)

data class Choice(
    val index: Int,
    val message: Message,
    val logprobs: String?,
    val finish_reason: String
)

data class Usage(
    val prompt_tokens: Int,
    val completion_tokens: Int,
    val total_tokens: Int
)