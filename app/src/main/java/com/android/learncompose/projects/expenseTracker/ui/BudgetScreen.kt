package com.android.learncompose.projects.expenseTracker.ui

import android.graphics.Paint.Align
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// screen structure
// Surface -> Col -> Row -> Surface -> LazyCol -> ButtonAtEnd

@Composable
fun BudgetScreenContent(modifier: Modifier = Modifier) {
    Surface (color = MaterialTheme.colorScheme.error, modifier = modifier.fillMaxSize()) {
        Column { // main column
            Row( // top row
                modifier = Modifier.fillMaxWidth().height(100.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null
                    )
                }
                Text(
                    "January 2025",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.weight(1f)
                )
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = null
                    )
                }
            }

            // inner content
            Surface(
                color = MaterialTheme.colorScheme.onError,
                shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp), modifier = Modifier.fillMaxHeight(),
            ) {
                Box(modifier = Modifier.padding(24.dp)) {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.padding(bottom = 56.dp)
                    ) {
                        items(transactions) { transaction ->
//                    TransactionCard(transaction = transaction)
                            BudgetCard(categoryColor = Color.Blue)
                        }
                    }

                    OutlinedButton(onClick = {}, modifier = Modifier.align(Alignment.BottomCenter).fillMaxWidth(),) {
                        Text(
                            "Add Budget",
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun BudgetCard(modifier: Modifier = Modifier, categoryColor: Color) {
    Card(modifier = Modifier.fillMaxWidth(), elevation = CardDefaults.cardElevation(12.dp)) {
        Column (modifier = Modifier.fillMaxSize().padding(8.dp)) {
            Text("Category")
            Text("Remaining Budget Rs.200", style = MaterialTheme.typography.titleMedium)
            LinearProgressIndicator(trackColor = categoryColor, modifier = Modifier.fillMaxWidth().height(8.dp), strokeCap = StrokeCap.Round, )
            Text("You've spent Rs.200 of Rs.1000", modifier = Modifier.padding(vertical = 12.dp))
        }
    }
}

//@Preview
//@Composable
//private fun PreviewBudget() {
////    BudgetCard()
//    BudgetScreenContent()
//}