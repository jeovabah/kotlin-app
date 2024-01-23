package com.marketplace.android.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marketplace.android.viewmodel.ProductSelectionViewModel

@Composable
fun BottomCard(viewModel: ProductSelectionViewModel) {
//    val totalPrice = viewModel.calculateTotalPrice() // Este método deve ser implementado no seu ViewModel
    val totalPrice = 25;
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        color = Color(0xFF_FFD600), // A cor de fundo amarela
        shadowElevation = 0.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Total: R$ $totalPrice",
                color = Color.Black,
                fontSize = 18.sp,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Button(
                onClick = { /* TODO: Implementar ação de finalização do pedido */ },
                modifier = Modifier.height(36.dp)
            ) {
                Text("Finalizar")
            }
        }
    }
}
