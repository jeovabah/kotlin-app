package com.marketplace.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.marketplace.android.ui.screens.LoginScreen
import com.marketplace.android.ui.screens.ProductSelectionScreen
import com.marketplace.android.ui.screens.RegisterScreen
import com.marketplace.android.ui.screens.WelcomeScreen
import com.marketplace.android.ui.theme.MARKETPLACETheme
import com.marketplace.android.utils.DataMocks
import com.marketplace.android.viewmodel.LoginViewModel
import com.marketplace.android.viewmodel.ProductSelectionViewModel
import com.marketplace.android.viewmodel.RegisterViewModel
import com.marketplace.android.viewmodel.WelcomeViewModel
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MARKETPLACETheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "welcome") {
                        composable("welcome") {
                            WelcomeScreen(WelcomeViewModel()) { navController.navigate("login") }
                        }
                        composable("login") {
                            LoginScreen(LoginViewModel(navController))
                        }
                        composable("register") {
                            val registerViewModel: RegisterViewModel = viewModel()
                            RegisterScreen(registerViewModel) { navController.navigate("shop") }
                        }
                        composable("shop") {
                            val productSelectionViewModel: ProductSelectionViewModel = viewModel()
                            productSelectionViewModel.loadCategories(DataMocks.mockCategories)
                            ProductSelectionScreen(productSelectionViewModel)
                        }
                    }
                }
            }
        }
    }
}
