package com.example.json

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class MainActivity: Activity() {
    lateinit var textContent: TextView
    lateinit var requestButton: Button
    lateinit var imageContent: ImageView

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
        textContent = findViewById(R.id.textView)
        requestButton = findViewById(R.id.button)

        requestButton.setOnClickListener {
            textContent.text = ""
        }

        requestButton.setOnClickListener{
            val client = ApiClient.retrofit.create(ApiInterface::class.java)
            client.getWeather().enqueue(object : retrofit2.Callback<WeatherResponse>{
                override fun onResponse(
                    call: retrofit2.Call<WeatherResponse>,
                    response: retrofit2.Response<WeatherResponse>
                ) {
                    if (response.isSuccessful){
                        val data = response.body()?.data
                        val message = "${data?.description} ${data?.temperature} ${data?.wind}"
                        textContent.text = message
                    }
                }
                override fun onFailure(call: retrofit2.Call<WeatherResponse>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_SHORT).show()
                }

            })
        }
    }
}