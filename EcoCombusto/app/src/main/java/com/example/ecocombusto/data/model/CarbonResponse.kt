package com.example.ecocombusto.data.model

import com.google.gson.annotations.SerializedName

data class CarbonResponse(
    @SerializedName("data") val data: CarbonData
)

data class CarbonData(
    @SerializedName("type") val type: String,
    @SerializedName("id") val id: String,
    @SerializedName("attributes") val attributes: CarbonAttributes
)

data class CarbonAttributes(
    @SerializedName("carbon_kg") val carbonKg: Double,
    @SerializedName("litros_consumidos") val litrosConsumidos: Double,
    @SerializedName("vehicle_id") val vehicleId: String,
    @SerializedName("distance_km") val distanceKm: Int
)
