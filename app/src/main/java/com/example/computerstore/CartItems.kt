package com.example.computerstore

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CartItem(product: CartItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = product.imageRes),
            contentDescription = product.name,
            modifier = Modifier.size(60.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(text = product.name, fontWeight = FontWeight.Bold)
            Text(text = product.id, color = Color.Gray, fontSize = 12.sp)

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { if (product.quantity > 1) product.quantity-- }) {
                    Text("-")
                }

                Text(text = product.quantity.toString(), fontSize = 16.sp)

                IconButton(onClick = { product.quantity++ }) {
                    Text("+")
                }

                Spacer(modifier = Modifier.width(8.dp))

                Text(text = "$${product.price * product.quantity}", fontWeight = FontWeight.Bold)
            }
        }

        IconButton(onClick = { /* Remove item from cart */ }) {
            Icon(Icons.Default.Close, contentDescription = "Remove")
        }
    }
}
