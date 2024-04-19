package com.example.aichat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.aichat.data.Retrofit
import com.example.aichat.data.model.ChatGptRequest
import com.example.aichat.data.model.Message
import com.example.aichat.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val chatGptService = Retrofit.service

        binding.SubmitButton.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {

                val response = chatGptService.createChatGpt(
                    "application/json",
                    "Bearer ${BuildConfig.API_KEY}",
                    ChatGptRequest(
                        model = "gpt-3.5-turbo",
                        messages = listOf(
                            Message(
                                role = "user",
                                content = binding.EditRequest.text.toString()
                            )
                        )
                    )
                )


                if (response.isSuccessful) {
                    Log.e("ChatGpt" , response.body()?.choices?.get(0)?.message?.content.toString())
                    runOnUiThread {
                        binding.ResultTextView.setText(response.body()?.choices?.get(0)?.message?.content.toString())
                    }

                } else{
                    Log.e("ChatGpt", response.code().toString() )
                }
            }
        }

    }
}