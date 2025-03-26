package com.example.myapplication.ui.componenets

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.myapplication.R
import com.example.myapplication.navigation.Screen

@Composable
fun BottomNavigationBar(navController: NavController) {
    val screens = listOf(Screen.Home, Screen.Go, Screen.Saved, Screen.Settings)
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    NavigationBar(containerColor = Color(0xFFF0EAF2), contentColor = Color.Black) {
        screens.forEach { screen ->
            NavigationBarItem(
                icon = { Icon(painterResource(id = screen.icon), contentDescription = screen.title) },
                label = { Text(screen.title) },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(Screen.Home.route) { inclusive = false }
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

//@Composable
//fun BottomNavigationBar() {
//    NavigationBar(
//        containerColor = Color(0xFFF0EAF2),
//        contentColor = Color.Black
//    ) {
//        NavigationBarItem(
//            icon = { Icon(painterResource(id = com.example.myapplication.R.drawable.ic_explore), contentDescription = "Explore", tint = Color.Unspecified) },
//            selected = false,
//            onClick = { /* TODO: Navigate */ }
//        )
//        NavigationBarItem(
//            icon = { Icon(painterResource(id = com.example.myapplication.R.drawable.ic_go), contentDescription = "Go") },
//            selected = false,
//            onClick = { /* TODO: Navigate */ }
//        )
//        NavigationBarItem(
//            icon = { Icon(painterResource(id = com.example.myapplication.R.drawable.ic_saved), contentDescription = "Saved") },
//            selected = false,
//            onClick = { /* TODO: Navigate */ }
//        )
//        NavigationBarItem(
//            icon = { Icon(painterResource(id = R.drawable.ic_settings), contentDescription = "Settings") },
//            selected = false,
//            onClick = { /* TODO: Navigate */ }
//        )
//    }
//}
