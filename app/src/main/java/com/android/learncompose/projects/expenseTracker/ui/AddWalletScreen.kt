package com.android.learncompose.projects.expenseTracker.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp

@Composable
fun AddWalletScreen(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.background(Color.Gray)) {
        Row (verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            }
                Text(
                    "Add New Wallet",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
                TextButton(onClick = {}) {
                    Text("Skip")
                }
            }

        Text("Balance")
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Rs.")
            OutlinedTextField(value = "", onValueChange = {})
        }

        Column (modifier = Modifier.clip(RoundedCornerShape(12.dp)).background(Color.White).fillMaxSize()) {
            OutlinedTextField(value = "", onValueChange = {}, placeholder = { Text("Wallet") })
            OutlinedTextField(value = "", onValueChange = {}, placeholder = { Text("Bank") })

            LazyHorizontalGrid(
                rows = GridCells.Fixed(2),
                modifier = Modifier.heightIn(max = 60.dp).align(alignment = Alignment.CenterHorizontally)
            ) {
                items(filters) { filterLabel ->
                    FilterChip(
                        selected = false,
                        onClick = {},
                        label = {
                            Text(filterLabel)
                        }
                    )
                }
            }

        }
    }
}


@Preview(widthDp = 300, heightDp = 650)
@Composable
private fun ScreenPreview() {
        AddWalletScreen()
}


val filters = listOf(
    "Chase",
    "HBL",
    "UBL",
    "CITI",
    "PTI",
    "STI",
)