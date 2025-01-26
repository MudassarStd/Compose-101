package com.android.learncompose.designPractice

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRailDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.learncompose.codelab2.HomeScreenContent
import com.android.learncompose.designPractice.ui.theme.LearnComposeTheme

class ScaffoldPracticeActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnComposeTheme {
                Main()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Main(modifier: Modifier = Modifier) {
    Scaffold (
        topBar  = { MyTopAppbar() },
        bottomBar = { MyBottomNavigation() },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        },
        content = { contentPadding ->
            HomeScreenContent(showDialog = {}, modifier = Modifier.padding(contentPadding))
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppbar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Text("Explore APIs")
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.ArrowBack, contentDescription = null, Modifier.padding(end = 8.dp)
            )
        },
        actions = {
            Row (horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Icon(imageVector = Icons.Default.Search, contentDescription = null)
            }
        }
    )
}

@Composable
fun MyBottomBar(modifier: Modifier = Modifier) {
    BottomAppBar(
        content = {
            Row  {
                Icon(imageVector = Icons.Default.Home, contentDescription = null)
                Icon(imageVector = Icons.Default.Favorite, contentDescription = null)
            }
        }
    )
}

@Composable
fun MyBottomNavigation(modifier: Modifier = Modifier) {
        NavigationBar {
            NavigationBarItem(
                onClick = {},
                label = {
                    Text("Home")
                },
                icon = {
                    Icon(imageVector = Icons.Default.Home, contentDescription = null)
                },
                selected = true
            )
            NavigationBarItem(
                onClick = {},
                label = { Text("Favorite") },
                icon = {
                    Icon(imageVector = Icons.Default.Favorite, contentDescription = null)
                },
                selected = false
            )
        }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    Main()
}