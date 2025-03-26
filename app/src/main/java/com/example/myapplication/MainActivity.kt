package com.example.myapplication


import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.navigation.NavGraph
import com.example.myapplication.viewmodel.AppViewModel
import com.example.myapplication.ui.componenets.BottomNavigationBar
import com.example.myapplication.ui.componenets.TopBar
import com.example.myapplication.ui.LoginScreen
import androidx.activity.viewModels
import androidx.lifecycle.compose.collectAsStateWithLifecycle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Create ViewModel using viewModels() delegate
            val appViewModel: AppViewModel by viewModels()

            // Collect login state
            val isUserLoggedIn by appViewModel.isUserLoggedIn.collectAsStateWithLifecycle()

            // Set up NavController
            val navController = rememberNavController()
            NavGraph(
                navController = navController,
                viewModel = appViewModel,
                startDestination = if (isUserLoggedIn) "home" else "login"
            )
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    if (isUserLoggedIn) {
                        MyApp(appViewModel) // Show main app after login
                    } else {
                        LoginScreen(navController, appViewModel) // Show login first
                    }

                }
            }
        }
    }
}

@Composable
fun MyApp(mainViewModel: AppViewModel) {
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopBar(mainViewModel) },
        bottomBar = { BottomNavigationBar(navController) }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            NavGraph(navController,mainViewModel)
        }
    }
}
