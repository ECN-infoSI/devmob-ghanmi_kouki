package com.example.myapplication.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.viewmodel.AppViewModel
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Delete

@Composable
@OptIn(ExperimentalPagerApi::class)
fun SavedItinerariesScreen(navController: NavController, viewModel: AppViewModel) {
    val transportMode by viewModel.transportMode.collectAsState()
    val userName by viewModel.userName.collectAsState()
    val pagerState = rememberPagerState()
    val tabs = listOf("Saved", "Shared", "Public")
    val itineraries = listOf("Itinerary 1", "Itinerary 2", "Itinerary 3")

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Saved Itineraries for $userName")
        Text("Transport: $transportMode")
        Tabs(tabs, pagerState)
        TabsContent(pagerState)
    }
}



@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(tabs: List<String>, pagerState: PagerState) {
    val coroutineScope = rememberCoroutineScope()

    TabRow(selectedTabIndex = pagerState.currentPage) {
        tabs.forEachIndexed { index, title ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                text = { Text(title) }
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsContent(pagerState: PagerState) {
    HorizontalPager(state = pagerState, count = 3) { page ->
        when (page) {
            0 -> ItinerariesList("Saved Itineraries")
            1 -> ItinerariesList("Shared Itineraries")
            2 -> ItinerariesList("Public Itineraries")
        }
    }
}

@Composable
fun ItinerariesList(title: String) {
    val itineraries = List(5) { "Itinerary ${it+1}" }

    LazyColumn(modifier = Modifier.padding(4.dp)) {
        items(itineraries) { itinerary ->
            Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(itinerary, style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        Button(onClick = { }) { Icon(imageVector = Icons.Filled.Edit, contentDescription = "Modify") }
                        Spacer(modifier = Modifier.width(8.dp))
                        Button(onClick = { }) { Icon(imageVector = Icons.Filled.Share, contentDescription = "Share") }
                        Spacer(modifier = Modifier.width(8.dp))
                        Button(onClick = { }) { Icon(imageVector = Icons.Filled.Delete, contentDescription = "Delete") }
                    }
                }
            }
        }
    }
}
