package com.example.ecocombusto.data.model

import com.google.gson.annotations.SerializedName

data class CompareResponse(
    @SerializedName("data") val data: List<CompareItem>
)

data class CompareItem(
    @SerializedName("fuel") val fuel: String,
    @SerializedName("carbon_kg") val carbonKg: Double
)
