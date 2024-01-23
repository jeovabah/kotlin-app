package com.marketplace.android.utils

data class Category(val name: String, val products: List<Product>)
data class Product(val name: String, val price: Double)

object DataMocks {
    val mockCategories = listOf(
        Category("Bebidas", listOf(
            Product("Água Mineral", 2.00),
            Product("Suco de Laranja", 5.00)
        )),
        Category("Snacks", listOf(
            Product("Batata Frita", 3.50),
            Product("Bolacha Recheada", 2.50)
        ))
    )
}
