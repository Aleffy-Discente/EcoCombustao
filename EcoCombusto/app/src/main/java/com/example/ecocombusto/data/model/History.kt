package com.example.ecocombusto.data.model

import com.google.gson.annotations.SerializedName

data class HistoryResponse(
    @SerializedName("data") val data: List<HistoryItem>
)

data class HistoryItem(
    @SerializedName("id") val id: String,
    @SerializedName("user_id") val userId: String,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("vehicle_id") val vehicleId: String,
    @SerializedName("distance_km") val distanceKm: Int,
    @SerializedName("carbon_kg") val carbonKg: Double
)
