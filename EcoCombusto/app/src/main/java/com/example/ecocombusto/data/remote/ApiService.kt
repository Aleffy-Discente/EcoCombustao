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
