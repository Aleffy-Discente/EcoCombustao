package com.example.ecocombusto.data.model

import com.google.gson.annotations.SerializedName

data class VehicleResponse(
    @SerializedName("data") val data: List<Vehicle>
)

data class Vehicle(
    @SerializedName("vehicle_id") val vehicleId: String,
    @SerializedName("type") val type: String,
    @SerializedName("brand") val brand: String,
    @SerializedName("model") val model: String,
    @SerializedName("fuel") val fuel: String,
    @SerializedName("consumo_l_km") val consumoPorKm: Double
)
