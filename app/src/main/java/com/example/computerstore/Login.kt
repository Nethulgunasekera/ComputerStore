package com.example.computerstore

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginUI(modifier: Modifier = Modifier, navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Title
        Text(
            text = "Lets Sign you in",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Subtitle
        Text(
            text = "Welcome to CloudMart",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Email, Phone or Username Input
        var email by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = email,
            onValueChange = { email = it },
            placeholder = {
                Text(
                    text = "Email, phone & username",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                .padding(8.dp),
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )

        // Password Input
        var password by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = password,
            onValueChange = { password = it },
            placeholder = {
                Text(
                    text = "Password",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                .padding(8.dp),
            singleLine = true,
            visualTransformation = VisualTransformation.None,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )

        // Forgot Password
        Text(
            text = "Forgot Password?",
            fontSize = 12.sp,
            color = Color.Gray,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )

        // Login Button
        Button(
            onClick = { navController.navigate("home") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Log in", fontSize = 14.sp, color = Color.White)
        }

        // OR Text
        Text(
            text = "or",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // Social Login Icons
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            SocialLoginButton(iconRes = R.drawable.google_icon, iconDescription = "Google")
            Spacer(modifier = Modifier.width(16.dp))
            SocialLoginButton(iconRes = R.drawable.facebook_icon, iconDescription = "Facebook")
            Spacer(modifier = Modifier.width(16.dp))
            SocialLoginButton(iconRes = R.drawable.apple_icon, iconDescription = "Apple")
        }

        // Register Now
        TextButton(
            onClick = { navController.navigate("signup") }, // Navigate to "signup"
            modifier = Modifier.padding(top = 24.dp)
        ) {
            Text(
                text = "Don't have an account? Register Now",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        }
    }
}

@Composable
fun SocialLoginButton(iconRes: Int, iconDescription: String) {
    IconButton(
        onClick = { /* Handle Social Login */ },
        modifier = Modifier.size(48.dp)
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = iconDescription,
            modifier = Modifier.size(24.dp)
        )
    }
}


