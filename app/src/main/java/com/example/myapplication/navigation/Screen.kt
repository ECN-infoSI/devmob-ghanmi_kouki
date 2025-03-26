package com.example.myapplication.navigation

import com.example.myapplication.R

sealed class Screen(val route: String, val icon: Int, val title: String) {
    object Home : Screen("home", R.drawable.ic_explore, "Explore")
    object Go : Screen("home", R.drawable.ic_go, "Go")
    object Saved : Screen("saved", R.drawable.ic_saved, "Saved")
    object Settings : Screen("home", R.drawable.ic_settings, "Settings")
}
