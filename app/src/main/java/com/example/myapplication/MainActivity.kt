package com.example.myapp
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    Scaffold(
        topBar = { TopBar() }, // Affiche la barre supérieure (TopAppBar)
        bottomBar = { BottomNavigationBar() } // Affiche la barre de navigation inférieure
    ) { paddingValues -> // Fournit un espace de remplissage pour éviter que le contenu ne soit caché sous les barres
        Box(modifier = Modifier.padding(paddingValues)) {
            HomeScreen() // Affiche l'écran principal de l'application
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = "") },
        navigationIcon = {
            IconButton(onClick = { /* TODO: Open menu */ }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Paul Silva", fontSize = 16.sp)
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(32.dp)
                        .background(Color.Gray, shape = CircleShape)
                        .clickable { /* TODO: Open Profile */ }
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
    )
}

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SearchBar()
        Spacer(modifier = Modifier.height(16.dp))
        TransportOptions()
        Spacer(modifier = Modifier.height(32.dp))
        NavigationButtons()
    }
}

@Composable
fun SearchBar() {
    TextField(
        value = "",
        onValueChange = {},
        placeholder = { Text("Recherche") },
        modifier = Modifier.fillMaxWidth().background(Color(0xFFF0EAF2), RoundedCornerShape(8.dp)),
        singleLine = true
    )
}

@Composable
fun TransportOptions() {
    Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
        TransportIcon(R.drawable.ic_car)
        TransportIcon(R.drawable.ic_bike)
        TransportIcon(R.drawable.ic_walk)
    }
}

@Composable
fun TransportIcon(iconRes: Int) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                modifier = Modifier
            .size(80.dp)
            .clickable { /* TODO: Select Transport */ }
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = "Transport",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun NavigationButtons() {
    Button(
        onClick = { /* TODO: Open Navigation */ },
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5E4784)),
        shape = RoundedCornerShape(24.dp)
    ) {
        Text(text = "Navigation", color = Color.White, fontSize = 18.sp)
    }

    Button(
        onClick = { /* TODO: Open Itineraries */ },
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5E4784)),
        shape = RoundedCornerShape(24.dp)
    ) {
        Text(text = "My Itineraries", color = Color.White, fontSize = 18.sp)
    }
}

@Composable
fun BottomNavigationBar() {
    NavigationBar(
        containerColor = Color(0xFFF0EAF2),
        contentColor = Color.Black
    ) {
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.ic_explore), contentDescription = "Explore") },
            selected = false,
            onClick = { /* TODO: Navigate */ }
        )
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.ic_go), contentDescription = "Go") },
            selected = false,
            onClick = { /* TODO: Navigate */ }
        )
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.ic_saved), contentDescription = "Saved") },
            selected = false,
            onClick = { /* TODO: Navigate */ }
        )
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.ic_settings), contentDescription = "Settings") },
            selected = false,
            onClick = { /* TODO: Navigate */ }
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewApp() {
    MyApp()
}


