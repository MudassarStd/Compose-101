package com.android.learncompose.projects.expenseTracker.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.learncompose.designPractice.ui.theme.LearnComposeTheme
import com.android.learncompose.projects.expenseTracker.components.MontraBottomBar

@Composable
fun TransactionDetailsScreen(modifier: Modifier = Modifier) {
    Column(modifier.padding()) {
        Box (modifier = Modifier.height(300.dp)) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp))
                    .height(250.dp)
                    .background(Color.Red)
            ) {
                // top row header
                Row (verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null, tint = Color.White)
                    }
                    Text(
                        "Transaction Details",
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleLarge
                    )
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Default.Delete, contentDescription = null, tint = Color.White)
                    }
                }
                Spacer(Modifier.height(24.dp))
                Text("Rs.200", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 22.sp)
                Spacer(Modifier.height(8.dp))
                Text("25 Feb 2025", color = Color.White)
                Text("03:08 pm", color = Color.White)
            }
            DetailsCardV2(Modifier.fillMaxWidth().align(Alignment.BottomCenter).padding(horizontal = 24.dp, vertical = 8.dp))
        }

        Column (modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)){
            Text("Description", style = MaterialTheme.typography.headlineMedium)
            Text("Lorem psim sativum", style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(vertical = 8.dp))
            Text("Attachment", style = MaterialTheme.typography.headlineMedium)
            Text("No attachment", style = MaterialTheme.typography.bodyMedium,  textAlign = TextAlign.Center)

            Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                Text("Edit")
            }
        }
    }
}

@Composable
fun DetailsCard(modifier: Modifier = Modifier) {
    Card(modifier = modifier, elevation = CardDefaults.cardElevation(12.dp)) {
        Column {
            Row (horizontalArrangement = Arrangement.SpaceBetween, modifier = modifier) {
                Text("Type", style = MaterialTheme.typography.titleMedium)
                Text("Category", style = MaterialTheme.typography.titleMedium)
                Text("Wallet", style = MaterialTheme.typography.titleMedium)
            }
            Row (horizontalArrangement = Arrangement.SpaceBetween, modifier = modifier) {
                Text("Expense")
                Text("Food")
                Text("HBL")
            }
        }
    }
}

@Composable
fun DetailsCardV2(modifier: Modifier = Modifier) {
    Card(modifier = modifier, elevation = CardDefaults.cardElevation(12.dp)) {
        Row (horizontalArrangement = Arrangement.SpaceBetween, modifier = modifier){

            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text("Type", style = MaterialTheme.typography.titleMedium)
                Text("Expense")
            }
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text("Category", style = MaterialTheme.typography.titleMedium)
                Text("Food")
            }
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text("Wallet", style = MaterialTheme.typography.titleMedium)
                Text("HBL")
            }

//            Row (horizontalArrangement = Arrangement.SpaceBetween, modifier = modifier) {
//                Text("Type", style = MaterialTheme.typography.titleMedium)
//                Text("Category", style = MaterialTheme.typography.titleMedium)
//                Text("Wallet", style = MaterialTheme.typography.titleMedium)
//            }
//            Row (horizontalArrangement = Arrangement.SpaceBetween, modifier = modifier) {
//                Text("Expense")
//                Text("Food")
//                Text("HBL")
//            }
        }
    }
}

@Preview
@Composable
private fun PreviewOnFull() {
    LearnComposeTheme {
        Scaffold(
            bottomBar = { MontraBottomBar() }
        ) { contentPadding ->
            TransactionDetailsScreen(Modifier.padding(contentPadding))
        }
    }
}