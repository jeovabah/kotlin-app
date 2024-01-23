package com.marketplace.android.viewmodel

import androidx.lifecycle.ViewModel
import java.util.logging.Logger

class RegisterViewModel : ViewModel() {
    fun register(userProps: Map<String, String>) {
        Logger.getLogger("RegisterViewModel").info(userProps.toString())
    }
}
