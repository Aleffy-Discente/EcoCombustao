package com.example.ecocombustao.data.repository

import com.example.ecocombustao.data.model.CarbonRequest
import com.example.ecocombustao.data.remote.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CarbonRepository {

    suspend fun calculateCarbon(
        km: Int,
        vehicleType: String
    ) = withContext(Dispatchers.IO) {
        val request = CarbonRequest(
            km = km,
            vehicleModel = vehicleType
        )

        RetrofitClient.api.getCarbonEstimation(request)
    }
}
