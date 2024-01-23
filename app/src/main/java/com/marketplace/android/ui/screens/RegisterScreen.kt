package com.marketplace.android.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.marketplace.android.viewmodel.RegisterViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(viewModel: RegisterViewModel, onRegistrationComplete: () -> Unit) {
    val (name, setName) = remember { mutableStateOf("") }
    val (cpf, setCpf) = remember { mutableStateOf("") }
    val (number, setNumber) = remember { mutableStateOf("") }
    val (dateOfBirth, setDateOfBirth) = remember { mutableStateOf("") }
    val (isRegistered, setIsRegistered) = remember { mutableStateOf(false) }

    // Simulate registration logic
    LaunchedEffect(isRegistered) {
        if (isRegistered) {
            onRegistrationComplete()
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Input(
            value = name,
            onValueChange = setName,
            label = "Seu Nome",
        )
        Spacer(modifier = Modifier.height(16.dp))
        Input(
            value = cpf,
            onValueChange = setCpf,
            label = "Seu Cpf",
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedTextField(
                modifier = Modifier.weight(1.5f),
                value = number,
                onValueChange = setNumber,
                label = { Text("Número") },
            )
            Spacer(modifier = Modifier.width(16.dp))
            OutlinedTextField(
                modifier = Modifier.weight(1f),
                value = dateOfBirth,
                onValueChange = setDateOfBirth,
                label = { Text("Nascimento") },
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        RegisterButton(viewModel, mapOf(
            "name" to name,
            "cpf" to cpf,
            "number" to number,
            "dateOfBirth" to dateOfBirth,
        ),
            setIsRegistered)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Input (label: String, value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
    )
}

@Composable
fun RegisterButton(viewModel: RegisterViewModel, userProps: Map<String, String>, setIsRegistered: (Boolean) -> Unit) {
    Button(
        modifier = Modifier.fillMaxWidth().height(48.dp),
        onClick = {
            setIsRegistered(true)
            viewModel.register(
            mapOf(
                "name" to userProps["name"]!!,
                "cpf" to userProps["cpf"]!!,
                "number" to userProps["number"]!!,
                "dateOfBirth" to userProps["dateOfBirth"]!!,
            )
        ) }) {
        Text("Registrar")
    }
}
