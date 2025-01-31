package com.example.computerstore

data class CartItem(
    val id: String,
    val name: String,
    val imageRes: Int,
    val price: Int,
    var quantity: Int
)
