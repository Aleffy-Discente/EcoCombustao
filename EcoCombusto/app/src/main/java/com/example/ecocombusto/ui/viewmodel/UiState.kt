package com.example.ecocombusto.ui.viewmodel

data class UiState(
    val loading: Boolean = false,
    val result: Double? = null,
    val error: String? = null
)