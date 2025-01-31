package com.example.computerstore

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ShoppingCartScreen(navController: NavController) {
    val products = remember {
        mutableStateListOf(
            CartItem(
                id = "#25139526913984",
                name = "Apple iPhone 14 Pro Max 128Gb Deep Purple",
                imageRes = R.drawable.iphone14,
                price = 1399,
                quantity = 1
            ),
            CartItem(
                id = "#63632324",
                name = "Apple Watch Series 9 GPS 41mm Starlight Aluminium",
                imageRes = R.drawable.watch2,
                price = 399,
                quantity = 1
            )
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
                .padding(bottom = 80.dp)


        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Shopping Cart",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                items(products) { product ->
                    CartItem(product)
                }
            }

            Divider()

            OrderSummary(products)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { products.clear() },
                    colors = ButtonDefaults.buttonColors(Color.Black)
                ) {
                    Text(text = "Clear", color = Color.White)
                }

                Button(
                    onClick = { /* Checkout action */ },
                    colors = ButtonDefaults.buttonColors(Color.Black)
                ) {
                    Text(text = "Check out", color = Color.White)
                }
            }
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        ) {
            Navbar(navController = navController)
        }

    }
}
