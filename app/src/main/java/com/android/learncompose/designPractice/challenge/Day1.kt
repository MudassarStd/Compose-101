package com.android.learncompose.designPractice.challenge

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun DialogComp(modifier: Modifier = Modifier) {
    Dialog(onDismissRequest = {}) {
        Column {
            Text(
                "Title",
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                "Content",
                style = MaterialTheme.typography.bodyMedium
            )

            Row (
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                ElevatedButton(onClick = {}) {
                    Text("Yes")
                }

                OutlinedButton(onClick = {}) {
                    Text("No")
                }
            }
        }
    }
}


@Preview
@Composable
private fun DialogPrev() {
    DialogComp()
}