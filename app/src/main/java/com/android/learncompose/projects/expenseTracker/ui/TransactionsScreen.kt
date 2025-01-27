package com.android.learncompose.projects.expenseTracker.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TransactionScreenContent(modifier: Modifier = Modifier) {
    Column (modifier.padding(horizontal = 16.dp)) {
        TopHeaderRow()
        OutlinedButton(onClick = {}, modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)) {
            Text("See your financial report")
            Icon(imageVector = Icons.Default.PlayArrow, contentDescription = null)
        }

        Text("Transactions", style = MaterialTheme.typography.titleMedium)
        HorizontalDivider(Modifier.padding(bottom = 12.dp))
        LazyColumn (verticalArrangement = Arrangement.spacedBy(8.dp)){
            items(transactions) { transaction ->
                TransactionCard(transaction = transaction)
            }
        }
    }

}

@Composable
fun TopHeaderRow(modifier: Modifier = Modifier) {
    Row (verticalAlignment = Alignment.CenterVertically) {
        ElevatedButton(onClick = {}, Modifier.weight(1f)) { Text("Jan 2025") }
        Icon(imageVector = Icons.Default.Delete, contentDescription = null)
        Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
    }
}