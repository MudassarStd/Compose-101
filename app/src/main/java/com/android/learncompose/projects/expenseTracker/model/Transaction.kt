package com.android.learncompose.projects.expenseTracker.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class Transaction(
    val icon: ImageVector,
    val category: String,
    val name: String,
    val amount: String,
    val date: String,
    val color: Color = Color.Gray
)
