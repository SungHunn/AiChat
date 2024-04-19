package com.example.aichat.data.model




data class ChatGptRequest(

    val model: String,
    val messages: List<Message>,

)

data class Message(

    val role: String,
    val content: String

)