package com.example.ecocombusto.data.model

import com.google.gson.annotations.SerializedName

data class CarbonRequest(
    @SerializedName("vehicle_id") val vehicleId: String,
    @SerializedName("distance_km") val distanceKm: Int,
    @SerializedName("user_id") val userId: String
)
