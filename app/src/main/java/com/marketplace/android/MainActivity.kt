package com.marketplace.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.marketplace.android.ui.screens.LoginScreen
import com.marketplace.android.ui.screens.RegisterScreen
import com.marketplace.android.ui.screens.WelcomeScreen
import com.marketplace.android.ui.theme.MARKETPLACETheme
import com.marketplace.android.viewmodel.LoginViewModel
import com.marketplace.android.viewmodel.RegisterViewModel
import com.marketplace.android.viewmodel.WelcomeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MARKETPLACETheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "welcome") {
                        composable("welcome") {
                            WelcomeScreen(WelcomeViewModel()) { navController.navigate("login") }
                        }
                        composable("login") {
                            LoginScreen(LoginViewModel())
                        }

                        composable("register") { RegisterScreen(RegisterViewModel()) }
                    }
                }
            }
        }
    }
}
