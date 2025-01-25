package com.android.learncompose.projects.expenseTracker.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import com.android.learncompose.R
import com.android.learncompose.codelab2.HomeScreen
import com.android.learncompose.projects.expenseTracker.model.Transaction
import kotlin.contracts.contract

@Composable
fun HomeScreenContent(modifier: Modifier = Modifier) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        // header row
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth())
        {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = "Profile Photo",
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
            )
            Text(
                text = "Month 2025",
                style = MaterialTheme.typography.titleMedium
            )

            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = null,
            )
        }

        Text("Total Amount", style = MaterialTheme.typography.titleSmall)
        Text("Rs. 100.00", style = MaterialTheme.typography.titleLarge)

        // income/expense card row
        Row (
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()

        ){
            IncomeExpenseCard(label = "Income", amount = "Rs. 100.00", color = Color.Green, modifier = Modifier.weight(1f))
            IncomeExpenseCard(label = "Expense", amount = "Rs. 100.00", color = Color.Red, modifier = Modifier.weight(1f))
        }

        Text("Spending Frequency",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.align(alignment = Alignment.Start))

        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "Spending Graph",
            modifier = Modifier
                .fillMaxWidth()
                .size(140.dp),
            contentScale = ContentScale.FillBounds
        )

        // Recent Transactions Header
        Row (
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ){
            Text(
                text = "Recent Transactions",
                style = MaterialTheme.typography.titleMedium,
            )

            ElevatedButton(
                onClick = {}
            ) { Text("See all") }
        }

        LazyColumn (
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            items(transactions) { transaction ->
                TransactionCard(transaction = transaction)
            }
        }
    }
}


@Composable
fun IncomeExpenseCard(modifier: Modifier = Modifier, label: String, amount: String, color: Color) {
    Surface (
        color = color,
        shadowElevation = 12.dp,
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
            .size(70.dp)

    ) {
        Row (horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically)
        {
            Icon(
                imageVector = Icons.Default.AccountBox,
                contentDescription = null,
                modifier = Modifier.padding(end = 8.dp)
//                tint = color
            )

            Column {
                Text(label)
                Text(amount)
            }
        }
    }
}

@Composable
fun TransactionCard(modifier: Modifier = Modifier, transaction: Transaction) {
    Card (
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier.fillMaxWidth().heightIn(max= 70.dp),
        onClick = {}

    ) {
        Row (
            modifier = Modifier.padding(horizontal = 8.dp).fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                imageVector = transaction.icon,
                contentDescription = null,
                tint = transaction.color,
                modifier = Modifier.size(32.dp).padding(end = 8.dp)
            )

            Column (modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)){
                Text(transaction.category)
                Text(transaction.name)
            }

            Column (
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ){
                Text(transaction.amount)
                Text(transaction.date)
            }
        }
    }
}



@Preview(showBackground = true, widthDp = 300, heightDp = 650)
@Composable
private fun HomeScreenContentPreview() {
    HomeScreenContent()
}


val transactions = listOf(
    Transaction(
        icon = Icons.Filled.ShoppingCart,
        category = "Shopping",
        name = "Amazon Purchase",
        amount = "$120.50",
        date = "2025-01-20"
    ),
    Transaction(
        icon = Icons.Filled.Face,
        category = "Food",
        name = "Grocery Store",
        amount = "$45.99",
        date = "2025-01-21"
    ),
    Transaction(
        icon = Icons.Filled.Lock,
        category = "Transport",
        name = "Gas Station",
        amount = "$65.30",
        date = "2025-01-22",
        color = Color.Cyan
    ),
    Transaction(
        icon = Icons.Filled.ShoppingCart,
        category = "Entertainment",
        name = "Movie Night",
        amount = "$15.00",
        date = "2025-01-23"
    ),
    Transaction(
        icon = Icons.Filled.Clear,
        category = "Travel",
        name = "Flight Ticket",
        amount = "$340.75",
        date = "2025-01-24",
        color = Color.Magenta
    )
)