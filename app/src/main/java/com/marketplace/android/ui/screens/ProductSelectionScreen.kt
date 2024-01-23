package com.marketplace.android.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.marketplace.android.ui.components.ProductCard
import com.marketplace.android.viewmodel.ProductSelectionViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductSelectionScreen(viewModel: ProductSelectionViewModel) {
    // Mock data
    val categories = viewModel.categories // Fetch this from your viewModel
    var selectedCategory by remember { mutableStateOf(categories.firstOrNull()) }
    val products = selectedCategory?.products ?: emptyList()

    Row(modifier = Modifier.fillMaxSize()) {
        // Category sidebar
        LazyColumn(
            modifier = Modifier
                .width(120.dp)
                .fillMaxHeight()
                .background(Color.Yellow)
        ) {
            items(categories) { category ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { selectedCategory = category }
                        .padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Replace with actual icon image
                    Icon(
                        imageVector = Icons.Default.AccountBox,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = category.name)
                }
            }
        }

        // Product display area
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .background(Color.White)
                .padding(16.dp)
        ) {
            Text(
                text = selectedCategory?.name ?: "Select a Category",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn {
                items(products) { product ->
                    ProductCard(
                        product = product)
                }
            }
        }
    }
}
