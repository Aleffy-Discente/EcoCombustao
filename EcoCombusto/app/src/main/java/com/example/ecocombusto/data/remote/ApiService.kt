package com.example.ecocombusto.data.remote

import com.example.ecocombusto.data.model.*
import retrofit2.http.*

interface ApiService {

    @POST("estimate")
    suspend fun getCarbonEstimation(
        @Body request: CarbonRequest
    ): CarbonResponse

    @GET("vehicles")
    suspend fun getVehicles(): VehicleResponse

    @GET("history/{user_id}")
    suspend fun getHistory(
        @Path("user_id") userId: String
    ): HistoryResponse

    @GET("compare")
    suspend fun compareFuels(
        @Query("distance") distance: Int
    ): CompareResponse

    @GET("stats")
    suspend fun getStats(): StatsResponse
}
/*
{
  "data": [
    {
      "vehicle_id": "car_001",
      "type": "car",
      "brand": "Toyota",
      "model": "Corolla 2.0",
      "fuel": "gasoline",
      "consumo_l_km": 0.071
    },
    {
      "vehicle_id": "bike_001",
      "type": "motorcycle",
      "brand": "Honda",
      "model": "CG 160",
      "fuel": "gasoline",
      "consumo_l_km": 0.04
    },
    {
      "vehicle_id": "plane_001",
      "type": "plane",
      "brand": "Boeing",
      "model": "737-800",
      "fuel": "kerosene",
      "consumo_l_km": 2.9
    }
  ]
}
 */