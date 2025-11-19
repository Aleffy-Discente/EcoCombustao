package com.example.ecocombustao.data.model

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
    @SerializedName("carbon_mt") val carbonMt: Double,
    @SerializedName("vehicle_model_id") val modelId: String,
    @SerializedName("distance_value") val distance: Int,
    @SerializedName("distance_unit") val unit: String
)
