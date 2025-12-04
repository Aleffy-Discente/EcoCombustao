package com.example.ecocombusto.ui.viewmodel

import com.example.ecocombusto.data.model.Vehicle

data class UiState(
    val loading: Boolean = false,
    val result: Double? = null,
    val error: String? = null,
    val vehicles: List<Vehicle> = emptyList()
)