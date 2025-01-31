package com.example.computerstore

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OrderSummary(products: List<CartItem>) {
    val subtotal = products.sumOf { it.price * it.quantity }
    val tax = 50
    val shipping = 29
    val total = subtotal + tax + shipping

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Text(text = "Order Summary", fontWeight = FontWeight.Bold, fontSize = 18.sp)

        SummaryRow("Subtotal", subtotal)
        SummaryRow("Estimated Tax", tax)
        SummaryRow("Estimated shipping & Handling", shipping)

        Divider(modifier = Modifier.padding(vertical = 8.dp))

        SummaryRow("Total", total, isBold = true)
    }
}

@Composable
fun SummaryRow(label: String, amount: Int, isBold: Boolean = false) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, fontWeight = if (isBold) FontWeight.Bold else FontWeight.Normal)
        Text(text = "$$amount", fontWeight = if (isBold) FontWeight.Bold else FontWeight.Normal)
    }
}
