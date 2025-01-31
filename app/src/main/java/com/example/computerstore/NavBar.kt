package com.example.computerstore

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun Navbar(navController: NavController){
    // Observe the back stack and get the current destination
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination?.route

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(MaterialTheme.colorScheme.onBackground),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        // Home Icon
        IconButton(
            onClick = {
                navController.popBackStack(navController.graph.startDestinationId, false)
                if (currentDestination != "home") {
                    navController.navigate("home")
                }
            }
        ) {
            Icon(
                imageVector = if (currentDestination == "home") Icons.Filled.Home else Icons.Outlined.Home,
                contentDescription = "Home",
                tint = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.size(24.dp)
            )
        }

        Spacer(modifier = Modifier.width(25.dp))
        IconButton(
            onClick = {
                navController.popBackStack(navController.graph.startDestinationId, false)
                if (currentDestination != "computers") {
                    navController.navigate("computers")
                }
            }
        ) {
            Icon(
                imageVector = if (currentDestination == "computers") Icons.Filled.Search else Icons.Outlined.Place,
                contentDescription = "Products",
                tint = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.size(24.dp)
            )
        }

        Spacer(modifier = Modifier.width(25.dp))

        // Explore Icon
        IconButton(
            onClick = {
                navController.popBackStack(navController.graph.startDestinationId, false)
                if (currentDestination != "cart") {
                    navController.navigate("cart")
                }
            }
        ) {
            Icon(
                imageVector = if (currentDestination == "cart") Icons.Filled.ShoppingCart else Icons.Outlined.ShoppingCart,
                contentDescription = "Explore",
                tint = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.size(24.dp)
            )
        }

        Spacer(modifier = Modifier.width(25.dp))

        // Profile Icon
        IconButton(
            onClick = {
                navController.popBackStack(navController.graph.startDestinationId, false)
                if (currentDestination != "profile") {
                    navController.navigate("profile")
                }
            }
        ) {
            Icon(
                imageVector = if (currentDestination == "profile") Icons.Filled.AccountCircle else Icons.Outlined.Person,
                contentDescription = "Profile",
                tint = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}