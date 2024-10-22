package com.example.tp2

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Bienvenue ", style = MaterialTheme.typography.headlineLarge)

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Clear login state from SharedPreferences
                val sharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
                with(sharedPreferences.edit()) {
                    putBoolean("is_logged_in", false)  // Mark user as logged out
                    apply()
                }

                // Navigate back to login and clear the backstack
                navController.navigate("login") {
                    popUpTo("home") { inclusive = true }  // Clears backstack to avoid returning to home screen
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Se déconnecter")
        }
    }
}
