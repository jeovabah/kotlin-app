package com.marketplace.android.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marketplace.android.viewmodel.LoginViewModel

@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFE1E2E1) // Ajuste a cor de fundo conforme necessário
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            LoginButton(
                icon = Icons.Default.AccountCircle,
                text = "JÁ TENHO CONTA",
                backgroundColor = Color(0xFF4CAF50), // Ajuste a cor do botão conforme necessário
                contentColor = Color.White
            ) {
                viewModel.onLoginClick();
            }

            Spacer(modifier = Modifier.height(16.dp))

            LoginButton(
                icon = Icons.Default.Lock,
                text = "PRIMEIRO ACESSO",
                backgroundColor = Color(0xFF2196F3), // Ajuste a cor do botão conforme necessário
                contentColor = Color.White
            ) { viewModel.onFirstAccessClick() }
        }
    }
}

@Composable
fun LoginButton(
    icon: ImageVector,
    text: String,
    backgroundColor: Color,
    contentColor: Color,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(backgroundColor)
            .clickable(onClick = onClick)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = text,
                tint = contentColor,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = text,
                color = contentColor,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}
