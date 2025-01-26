package com.android.learncompose.projects.expenseTracker.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MontraTopAppbar(modifier: Modifier = Modifier) {
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
fun MontraBottomBar(modifier: Modifier = Modifier) {
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
fun MontraBottomNavigation(modifier: Modifier = Modifier) {
    NavigationBar {
        NavigationBarItem(
            onClick = {},
            label = {Text("Home") },
            icon = {Icon(imageVector = Icons.Default.Home, contentDescription = null) },
            selected = true
        )
        NavigationBarItem(
            onClick = {},
            label = { Text("Transactions") },
            icon = {Icon(imageVector = Icons.Default.Favorite, contentDescription = null)},
            selected = false
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            label = {Text("Budget")},
            icon = { Icon(imageVector = Icons.Default.AccountBox, contentDescription = null) }
        )

        NavigationBarItem(
            selected = false,
            onClick = {},
            label = {Text("Profile")},
            icon = {Icon(imageVector = Icons.Default.Person, contentDescription = null)}
        )
    }
}
