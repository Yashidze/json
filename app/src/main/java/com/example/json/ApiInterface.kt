package com.example.json

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("weather/Kyiv")
    fun getWeather(): Call<WeatherResponse>
}