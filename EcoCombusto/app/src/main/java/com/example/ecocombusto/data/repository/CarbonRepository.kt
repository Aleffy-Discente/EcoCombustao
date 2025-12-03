package com.example.ecocombusto.data.repository

import com.example.ecocombusto.data.model.CarbonRequest
import com.example.ecocombusto.data.model.CarbonResponse
import com.example.ecocombusto.data.remote.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CarbonRepository {

    suspend fun calculateCarbon(
        km: Int,
        vehicleType: String
    ): Result<CarbonResponse> = withContext(Dispatchers.IO) {
        try {
            val request = CarbonRequest(
                km = km,
                vehicleModel = vehicleType
            )
            val response = RetrofitClient.api.getCarbonEstimation(request)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
