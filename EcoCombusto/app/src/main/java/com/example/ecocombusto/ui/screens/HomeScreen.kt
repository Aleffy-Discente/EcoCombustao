package com.example.ecocombusto.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ecocombusto.ui.viewmodel.CarbonViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun HomeScreen(
    vm: CarbonViewModel = viewModel(),
    onNavigateToResult: (Float) -> Unit
) {
    val state by vm.state.collectAsState()
    val context = LocalContext.current

    var km by remember { mutableStateOf("") }
    var model by remember { mutableStateOf("") }

    LaunchedEffect(true) {
        vm.events.collectLatest { message ->
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

            if (state.result != null) {
                onNavigateToResult(state.result!!.toFloat())
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Text(
            text = "EcoCombustão",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(Modifier.height(16.dp))

        TextField(
            value = km,
            onValueChange = { km = it.filter { ch -> ch.isDigit() } },
            label = { Text("Distância (km)") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(12.dp))

        TextField(
            value = model,
            onValueChange = { model = it },
            label = { Text("Modelo (car_001, bike_001, plane_001)") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {
                if (km.isNotEmpty()) {
                    vm.calculateCarbon(km.toInt(), model)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular emissões")
        }

        Spacer(Modifier.height(16.dp))

        if (state.loading) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator()
            }
        }
    }
}
