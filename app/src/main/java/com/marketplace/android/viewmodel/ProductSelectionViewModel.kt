package com.marketplace.android.viewmodel

import androidx.lifecycle.ViewModel
import com.marketplace.android.utils.Category

class ProductSelectionViewModel : ViewModel() {
    var categories: List<Category> = listOf()
        private set

    fun loadCategories(mockCategories: List<Category>) {
        categories = mockCategories
    }
}
