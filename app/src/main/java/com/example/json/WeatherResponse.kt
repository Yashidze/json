package com.example.json

class WeatherResponse(val data: Data) {
}

data class Data (
    val temperature: String,
    val wind: String,
    val description: String
)