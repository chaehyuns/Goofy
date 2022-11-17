package com.groom3.goofy.model


import com.google.gson.annotations.SerializedName

data class Grade(
    @SerializedName("AirTemp")
    val airTemp: String,
    @SerializedName("WaterTemp")
    val waterTemp: String,
    @SerializedName("WaveGrade")
    val waveGrade: String,
    @SerializedName("WaveHeight")
    val waveHeight: String,
    @SerializedName("WindSpeed")
    val windSpeed: String
)