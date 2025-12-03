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

    fun calculateCarbon(km: Int, model: String) {
        viewModelScope.launch {
            _state.value = UiState(loading = true)

            try {
                val response = repository.calculateCarbon(km, model)
                val carbon = response.data.attributes.carbonMt

                _state.value = UiState(
                    loading = false,
                    result = carbon
                )

                _events.send("Cálculo realizado com sucesso")

            } catch (e: Exception) {
                _state.value = UiState(
                    loading = false,
                    error = e.message
                )

                _events.send("Erro ao calcular emissões")
            }
        }
    }
}
