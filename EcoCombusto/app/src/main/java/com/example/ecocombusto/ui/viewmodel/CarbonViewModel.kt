package com.example.ecocombusto.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecocombusto.data.repository.CarbonRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class CarbonViewModel(
    private val repository: CarbonRepository = CarbonRepository()
) : ViewModel() {

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    private val _events = Channel<String>()
    val events = _events.receiveAsFlow()

    init {
        loadVehicles()
    }

    private fun loadVehicles() {
        viewModelScope.launch {
            val response = repository.getVehicles()
            response.onSuccess {
                _state.value = _state.value.copy(vehicles = it)
            }
        }
    }

    fun calculateCarbon(km: Int, vehicleId: String) {
        viewModelScope.launch {
            _state.value = _state.value.copy(loading = true)

            try {
                val response = repository.calculateCarbon(
                    vehicleId = vehicleId,
                    distanceKm = km,
                    userId = "u1039"
                ).getOrThrow()

                val carbon = response.data.attributes.carbonKg

                _state.value = _state.value.copy(
                    loading = false,
                    result = carbon
                )

                _events.send("Cálculo realizado com sucesso")

            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    loading = false,
                    error = e.message
                )
                _events.send("Erro ao calcular emissões")
            }
        }
    }
}
