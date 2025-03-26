package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.ui.HomeScreen
import com.example.myapplication.ui.LoginScreen
import com.example.myapplication.ui.SavedItinerariesScreen
import com.example.myapplication.viewmodel.AppViewModel

@Composable
fun NavGraph(navController: NavHostController, viewModel: AppViewModel,startDestination: String = "login") {
    NavHost(navController, startDestination = startDestination) {
        composable("login") { LoginScreen(navController, viewModel) }
        composable("home") { HomeScreen(navController, viewModel) }
        composable("saved") { SavedItinerariesScreen(navController, viewModel) }
    }
}
