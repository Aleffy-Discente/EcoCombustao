package com.example.ecocombusto.data.repository

import com.example.ecocombusto.data.model.*
import com.example.ecocombusto.data.remote.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CarbonRepository {

    suspend fun calculateCarbon(
        vehicleId: String,
        distanceKm: Int,
        userId: String
    ): Result<CarbonResponse> = withContext(Dispatchers.IO) {
        try {
            val request = CarbonRequest(
                vehicleId = vehicleId,
                distanceKm = distanceKm,
                userId = userId
            )

            val response = RetrofitClient.api.getCarbonEstimation(request)
            Result.success(response)

        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getVehicles(): Result<List<Vehicle>> = withContext(Dispatchers.IO) {
        try {
            val response = RetrofitClient.api.getVehicles()
            Result.success(response.data)

        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
