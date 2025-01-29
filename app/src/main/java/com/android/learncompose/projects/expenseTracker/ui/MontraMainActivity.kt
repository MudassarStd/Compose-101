package com.android.learncompose.projects.expenseTracker.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.android.learncompose.designPractice.MyBottomNavigation
import com.android.learncompose.projects.expenseTracker.components.MontraBottomNavigation
import com.android.learncompose.projects.expenseTracker.ui.ui.theme.LearnComposeTheme

class MontraMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    bottomBar = { MontraBottomNavigation() },
//                    floatingActionButton = {
//                        FloatingActionButton(
//                            onClick = {},
//                            content = {
//                                Text("+")
//                            }
//                        )
//                    }
                    )
                { innerPadding ->
                    TransactionDetailsScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Composable
fun MontraMain(modifier: Modifier = Modifier) {
    HomeScreenContent(modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    LearnComposeTheme {
        Scaffold(modifier = Modifier.fillMaxSize(),
            bottomBar = { MontraBottomNavigation() },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {},
                    content = {
                        Icon(imageVector = Icons.Filled.Add, contentDescription = null)
                    }
                )
            }
        )
        { innerPadding ->
            AddIncomeExpenseScreen(modifier = Modifier.padding(innerPadding))
        }
    }
}