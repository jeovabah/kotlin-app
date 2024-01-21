package com.marketplace.android.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marketplace.android.R
import com.marketplace.android.viewmodel.WelcomeViewModel

@Composable
fun WelcomeScreen(viewModel: WelcomeViewModel, onContinueClicked: () -> Unit) {
    // Substitute with your actual logo resource
    val logo = painterResource(id = R.drawable.logo)

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .clickable(onClick = onContinueClicked),
        color = MaterialTheme.colorScheme.primary
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = logo,
                    contentDescription = "Logo",
                    modifier = Modifier.size(100.dp) // Adjust the size as needed
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "Food for Office",
                    fontSize = 32.sp, // Adjust the font size as needed
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = "TOQUE NA TELA PARA COMEÇAR!!!",
                    fontSize = 18.sp, // Adjust the font size as needed
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            }
        }
    }
}
