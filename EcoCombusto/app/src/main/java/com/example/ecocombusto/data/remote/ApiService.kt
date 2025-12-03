package com.example.ecocombusto.data.remote

import com.example.ecocombusto.data.model.CarbonRequest
import com.example.ecocombusto.data.model.CarbonResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {

    @Headers(
        "Authorization: Bearer YOUR_API_KEY",
        "Content-Type: application/json"
    )
    @POST("v1/estimates")
    suspend fun getCarbonEstimation(
        @Body request: CarbonRequest
    ): CarbonResponse
}
