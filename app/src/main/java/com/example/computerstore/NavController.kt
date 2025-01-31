package com.example.computerstore

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(modifier: Modifier = Modifier){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login", builder = {

        composable("signup"){
            SignUpUI(navController)
        }
        composable("login"){
            LoginUI(modifier, navController);
        }
        composable("home"){
            HomeScreen(navController)
        }

        composable("phones"){
            PhoneScreen(navController)
        }
        composable("computers"){
            ComputerScreen(navController)
        }
        composable("headphones"){
            HeadSetScreen(navController)
        }
        composable("cameras"){
            CameraScreen(navController)
        }
        composable("watches"){
            WatchesScreen(navController)
        }
        composable("cart"){
            ShoppingCartScreen(navController)
        }
        composable("profile"){
              ProfileScreen(navController)
        }
        composable("productDetail/{productId}") { backStackEntry ->
            val context = LocalContext.current
            val productId = backStackEntry.arguments?.getString("productId")?.toIntOrNull()
            val allProducts = DataSource().loadPhones(context) +
                    DataSource().loadComputers(context) +
                    DataSource().loadWatches(context) +
                    DataSource().loadHeadsets(context) +
                    DataSource().loadCamerasAndTablets(context)

            val product = allProducts.find { it.id == productId }
            product?.let {
                ProductDetailScreen(it, navController)
            }
        }
    })
}