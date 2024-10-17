package com.example.tp2 
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tp2.ui.theme.Tp2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tp2Theme {
                val navController = rememberNavController()
                NavigationGraph(navController)
            }
        }
    }
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("register") { RegisterScreen(navController) }
        composable("forgot_password") { ForgotPasswordScreen(navController) }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Tp2Theme { // Correction de l'utilisation de Tp2Theme
        val navController = rememberNavController()
        NavigationGraph(navController)
    }
}