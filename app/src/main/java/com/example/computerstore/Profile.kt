package com.example.computerstore

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ProfileScreen(navController: NavController) {
    var name by remember { mutableStateOf("Nethul Gunsekera") }
    var email by remember { mutableStateOf("Nethulgunasekera@gmail.com") }
    var password by remember { mutableStateOf("***********") }
    var dob by remember { mutableStateOf("20/06/2004") }
    var country by remember { mutableStateOf("Sri Lanka") }
    var phone by remember { mutableStateOf("071-4814375") }
    var address by remember { mutableStateOf("No.18 rockview estate pahalakadugannawa") }

    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(scrollState)
                .padding(bottom = 80.dp) // Prevents cut-off content
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { /* Handle back navigation */ }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Edit Profile",
                fontSize = 22.sp,
                color = Color.Black,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Profile Image Placeholder
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .align(Alignment.CenterHorizontally),
                contentAlignment = Alignment.BottomEnd
            ) {
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray)
                )
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Change Profile Picture",
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .background(Color.DarkGray)
                        .align(Alignment.BottomEnd)
                        .padding(4.dp),
                    tint = Color.White
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Input Fields
            EditTextField("Name", name) { name = it }
            EditTextField("Email", email) { email = it }
            EditTextField("Password", password, isPassword = true) { password = it }
            EditTextField("Date of Birth", dob) { dob = it }
            EditTextField("Country/Region", country) { country = it }
            EditTextField("Phone Number", phone) { phone = it }
            EditTextField("Address", address) { address = it }

            Spacer(modifier = Modifier.height(16.dp))

            // Buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { /* Clear All */ },
                    colors = ButtonDefaults.buttonColors(Color.Black),
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                ) {
                    Text(text = "Clear All", color = Color.White)
                }
                Button(
                    onClick = { /* Save Changes */ },
                    colors = ButtonDefaults.buttonColors(Color.Black),
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                ) {
                    Text(text = "Save Changes", color = Color.White)
                }
            }

            Spacer(modifier = Modifier.height(16.dp)) // Extra space at bottom
        }

        // Navbar outside the scroll area
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        ) {
            Navbar(navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTextField(label: String, value: String, isPassword: Boolean = false, onValueChange: (String) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = label, fontSize = 14.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(4.dp))
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
            textStyle = androidx.compose.ui.text.TextStyle(color = Color.Black), // Ensures text is black
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Gray,
            ),
            shape = RoundedCornerShape(8.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}
