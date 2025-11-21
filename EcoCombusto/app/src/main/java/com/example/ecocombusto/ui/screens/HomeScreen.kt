package com.example.ecocombustao.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ecocombustao.ui.viewmodel.CarbonViewModel
import com.example.ecocombustao.ui.viewmodel.UiEvent
import kotlinx.coroutines.flow.collectLatest

@Composable
fun HomeScreen(
    vm: CarbonViewModel = viewModel(),
    onNavigateToResult: (Float) -> Unit
) {
    val state by vm.uiState.collectAsState()
    val context = LocalContext.current

    var km by remember { mutableStateOf("") }
    var model by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        vm.events.collectLatest { ev ->
            when (ev) {
                is UiEvent.ShowError -> {
                    Toast.makeText(context, ev.message, Toast.LENGTH_SHORT).show()
                }
                is UiEvent.NavigateToResult -> {
                    onNavigateToResult(ev.carbonKg)
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "EcoCombustão",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.semantics { contentDescription = "Título do app" }
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = km,
            onValueChange = { km = it.filter { ch -> ch.isDigit() } },
            label = { Text("Distância (km)") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .semantics { contentDescription = "Campo para inserir distância em quilômetros" }
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = model,
            onValueChange = { model = it },
            label = { Text("Modelo / combustível (ex: gasoline_passenger)") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .semantics { contentDescription = "Campo para inserir modelo do veículo ou tipo de combustível" }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { vm.calculate(km, model) },
            modifier = Modifier
                .fillMaxWidth()
                .semantics { contentDescription = "Botão calcular emissões" }
        ) {
            Text("Calcular emissões")
        }

        Spacer(modifier = Modifier.height(12.dp))

        if (state.isLoading) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                CircularProgressIndicator(modifier = Modifier.semantics { contentDescription = "Carregando" })
            }
        }
    }
}
