package com.example.ecocombustao.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecocombustao.data.repository.CarbonRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class CarbonViewModel(
    private val repository: CarbonRepository = CarbonRepository()
) : ViewModel() {

    data class UiState(
        val loading: Boolean = false,
        val result: Double? = null,
        val error: String? = null
    )

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    // One-shot events
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
