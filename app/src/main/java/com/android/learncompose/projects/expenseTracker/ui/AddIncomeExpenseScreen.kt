package com.android.learncompose.projects.expenseTracker.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.invalidateGroupsWithKey
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.learncompose.projects.expenseTracker.components.MontraBottomNavigation
import com.android.learncompose.projects.expenseTracker.ui.ui.theme.LearnComposeTheme

// surface cover whole
// Column {# TV()}
//


@Composable
fun AddIncomeExpenseScreen(modifier: Modifier = Modifier, backgroundColor: Color = Color.Yellow) {
    Surface(color = Color.Green, modifier = modifier.fillMaxSize()) {
        // Main Column
        Column {
            // Top Row
            Row(modifier = Modifier.height(60.dp), verticalAlignment = Alignment.CenterVertically) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                Text(
                    "Income",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
            }

            Text("How much?")
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Rs.")
                TextField(value = "0", onValueChange = {}, )
            }
            Text("How much?", modifier = Modifier.align(alignment = Alignment.End))

            // Inner surface
            Surface(
                color = Color.White,
                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
                modifier = Modifier.fillMaxSize().padding(top = 24.dp)
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 32.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        placeholder = {
                            Text("Category")
                        },
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowDown,
                                contentDescription = null
                            )
                        },
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        placeholder = {
                            Text("Description")
                        },
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        placeholder = {
                            Text("Wallet")
                        },
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowDown,
                                contentDescription = null
                            )
                        },
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedButton(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                        Icon(imageVector = Icons.Default.Create, contentDescription = null)
                        Text("Add attachment")
                    }

                        Text(
                            "Repeat",
                            style = MaterialTheme.typography.titleMedium,
                        )

                    Row (verticalAlignment = Alignment.CenterVertically){
                        Text(
                            "Repeat Frequency",
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.weight(1f)
                        )

                        Switch(
                            checked = false,
                            onCheckedChange = {}
                        )
                    }

                    Box (modifier = Modifier.fillMaxWidth().wrapContentHeight()) {
                        Text(
                            "Frequency",
                            style = MaterialTheme.typography.titleSmall,
                            modifier = Modifier.align(Alignment.TopStart)
                        )
                        Text(
                            "End After",
                            style = MaterialTheme.typography.titleSmall,
                            modifier = Modifier.align(Alignment.TopCenter)
                        )
                        Text(
                            "Yearly - 29 Dec",
                            modifier = Modifier.align(Alignment.BottomStart)
                        )
                        Text(
                            "Yearly - 29 Dec",
                            modifier = Modifier.align(Alignment.BottomCenter)
                        )

                        ElevatedButton(onClick = {}, modifier = Modifier.align(Alignment.CenterEnd)) {
                            Text("Edit")
                        }
                    }

                    ElevatedButton(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                        Text("Continue")
                    }


                }
            }


        }
    }
}


@Preview(showBackground = true)
@Composable
fun IncomeExpensePreview() {
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













//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.AccountBox
//import androidx.compose.material.icons.filled.Add
//import androidx.compose.material.icons.filled.DateRange
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.android.learncompose.ui.theme.LearnComposeTheme
//import com.android.learncompose.ui.theme.Purple40
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            com.android.learncompose.designPractice.ui.theme.LearnComposeTheme {
//                IncomeExpenseScreen()
//            }
//        }
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun IncomeExpenseScreen() {
//    var amount by remember { mutableStateOf("") }
//    var category by remember { mutableStateOf("") }
//    var date by remember { mutableStateOf("") }
//    var notes by remember { mutableStateOf("") }
//    var isIncome by remember { mutableStateOf(true) }
//
//    Scaffold(
//        floatingActionButton = {
//            FloatingActionButton(
//                onClick = { /* Save the entry */ },
//                containerColor = Purple40,
//                contentColor = Color.White
//            ) {
//                Icon(imageVector = Icons.Default.Add, contentDescription = "Save")
//            }
//        }
//    ) { paddingValues ->
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(paddingValues)
//                .padding(16.dp),
//            verticalArrangement = Arrangement.spacedBy(16.dp)
//        ) {
//            // Toggle for Income/Expense
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.Center
//            ) {
//                FilterChip(
//                    selected = isIncome,
//                    onClick = { isIncome = true },
//                    label = { Text("Income") },
//                    colors = FilterChipDefaults.filterChipColors(
//                        selectedContainerColor = Purple40,
//                        selectedLabelColor = Color.White
//                    )
//                )
//                Spacer(modifier = Modifier.width(16.dp))
//                FilterChip(
//                    selected = !isIncome,
//                    onClick = { isIncome = false },
//                    label = { Text("Expense") },
//                    colors = FilterChipDefaults.filterChipColors(
//                        selectedLabelColor = Color.White
//                    )
//                )
//            }
//
//            // Amount Input
//            OutlinedTextField(
//                value = amount,
//                onValueChange = { amount = it },
//                label = { Text("Amount") },
//                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//                leadingIcon = { Icon(Icons.Default.Add, contentDescription = "Amount") },
//                modifier = Modifier.fillMaxWidth(),
//                shape = RoundedCornerShape(12.dp)
//            )
//
//            // Category Input
//            OutlinedTextField(
//                value = category,
//                onValueChange = { category = it },
//                label = { Text("Category") },
//                leadingIcon = { Icon(Icons.Default.AccountBox, contentDescription = "Category") },
//                modifier = Modifier.fillMaxWidth(),
//                shape = RoundedCornerShape(12.dp)
//            )
//
//            // Date Input
//            OutlinedTextField(
//                value = date,
//                onValueChange = { date = it },
//                label = { Text("Date") },
//                leadingIcon = { Icon(Icons.Default.DateRange, contentDescription = "Date") },
//                modifier = Modifier.fillMaxWidth(),
//                shape = RoundedCornerShape(12.dp)
//            )
//
//            // Notes Input
//            OutlinedTextField(
//                value = notes,
//                onValueChange = { notes = it },
//                label = { Text("Notes") },
//                leadingIcon = { Icon(Icons.Default.AccountBox, contentDescription = "Notes") },
//                modifier = Modifier.fillMaxWidth(),
//                shape = RoundedCornerShape(12.dp),
//                maxLines = 3
//            )
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun PreviewIncomeExpenseScreen() {
//    LearnComposeTheme {
//        IncomeExpenseScreen()
//    }
//}