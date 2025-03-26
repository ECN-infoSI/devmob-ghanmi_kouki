package com.example.myapplication.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.viewmodel.AppViewModel
import androidx.compose.foundation.background
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.Color
import com.example.myapplication.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape

@Composable
fun HomeScreen(navController: NavController, viewModel: AppViewModel) {
    val userName by viewModel.userName.collectAsState()
    val selectedTransport by viewModel.transportMode.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome, $userName")
        SearchBar()
        Spacer(modifier = Modifier.height(16.dp))
        TransportOptions(selectedTransport = selectedTransport,
            onTransportSelected = { transport ->
                viewModel.setTransportMode(transport)
            })
        Spacer(modifier = Modifier.height(32.dp))
        NavigationButtons(navController)
    }
}


@Composable
fun SearchBar() {
    TextField(
        value = "",
        onValueChange = {},
        placeholder = { Text("Search") },
        modifier = Modifier.fillMaxWidth().background(Color(0xFFF0EAF2), RoundedCornerShape(8.dp)),
        singleLine = true
    )
}

@Composable
fun TransportOptions(
    selectedTransport: String,
    onTransportSelected: (String) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        TransportIcon(
            iconRes = R.drawable.ic_car,
            name = "car",
            isSelected = selectedTransport == "car",
            onSelect = { onTransportSelected("car") }
        )
        TransportIcon(
            iconRes = R.drawable.ic_bike,
            name = "bike",
            isSelected = selectedTransport == "bike",
            onSelect = { onTransportSelected("bike") }
        )
        TransportIcon(
            iconRes = R.drawable.ic_walk,
            name = "walking",
            isSelected = selectedTransport == "walking",
            onSelect = { onTransportSelected("walking") }
        )
    }
}

@Composable
fun TransportIcon(
    iconRes: Int,
    name: String,
    isSelected: Boolean,
    onSelect: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .size(80.dp)
            .clickable { onSelect() },
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) Color(0xFFE0E0E0) else Color.White
        )
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = "Transport $name",
            modifier = Modifier.padding(16.dp),
            colorFilter = null
        )
    }
}

@Composable
fun NavigationButtons(navController: NavController) {
    Button(
        onClick = { /* TODO: Open Navigation */ },
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5E4784)),
        shape = RoundedCornerShape(24.dp)
    ) {
        Text(text = "Navigation", color = Color.White, fontSize = 18.sp)
    }

    Button(
        onClick = { navController.navigate("saved") },
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5E4784)),
        shape = RoundedCornerShape(24.dp)
    ) {
        Text(text = "My Itineraries", color = Color.White, fontSize = 18.sp)
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun PreviewHome2() {
//    HomeScreen(rememberNavController())
//}