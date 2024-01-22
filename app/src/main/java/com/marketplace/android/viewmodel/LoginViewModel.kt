package com.marketplace.android.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

class LoginViewModel(private val navController: NavController) : ViewModel() {
    fun onLoginClick() {
        navController.navigate("loginAuth");
    }

    fun onFirstAccessClick() {
        navController.navigate("register");
    }
}
