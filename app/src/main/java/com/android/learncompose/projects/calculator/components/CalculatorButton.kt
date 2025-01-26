package com.android.learncompose.projects.calculator.components

import android.widget.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.learncompose.projects.calculator.CalculatorViewModel
import com.android.learncompose.projects.calculator.eventHandler.CalculatorAction
import com.android.learncompose.projects.calculator.eventHandler.CalculatorOperation

// define comps
// define events that will be triggered on button clicks
// events will be fed to viewmodel to update UI
// in order to update UI, we need state of UI, so we define state as well

// 4 things attached
// comp
// event
// state
// UI

// a mock flow

// user interaction with comp -> creates an -> event -> fed -> viewmodel -> determine event and update -> state -> that in result updates -> UI

@Composable
fun CalculatorButton(
    modifier: Modifier = Modifier,
    symbol: String,
    color: Color,
    onClick: () -> Unit) {

    Button(modifier = modifier, onClick = onClick, shape = RoundedCornerShape(100)) {
        Text(symbol)
    }

//    Box(
//        modifier = Modifier
//            .clip(CircleShape)
//            .then(modifier),
//        contentAlignment = Alignment.Center,
//    ) {
//        Text(
//            text = symbol
//        )
//    }
}

@Composable
fun ButtonsSection(modifier: Modifier = Modifier) {
    val viewModel  = CalculatorViewModel()
    val state = viewModel.state

    Surface {
        Column (verticalArrangement = Arrangement.spacedBy(4.dp))
        {
            Text(
                text= state.num1+state.operation+state.num2 ,
                modifier = Modifier.align(alignment = Alignment.End)
            )

            Row (horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                CalculatorButton(symbol = "C", color = Color.Blue, onClick = {
                    viewModel.onAction(CalculatorAction.Clear)
                })
                CalculatorButton(symbol = "()", color = Color.Blue, onClick = {})
                CalculatorButton(symbol = "%", color = Color.Blue, onClick = {})
                CalculatorButton(symbol = "/", color = Color.Blue, onClick = {})
            }

            Row (horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                CalculatorButton(symbol = "7", color = Color.White, onClick = {
                    viewModel.onAction(CalculatorAction.Number(7))
                })
                CalculatorButton(symbol = "8", color = Color.White, onClick = {
                    viewModel.onAction(CalculatorAction.Number(8))
                })
                CalculatorButton(symbol = "9", color = Color.White, onClick = {
                    viewModel.onAction(CalculatorAction.Number(9))
                })
                CalculatorButton(symbol = "X", color = Color.Blue, onClick = {
                    viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                })
            }

            Row (horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                CalculatorButton(symbol = "4", color = Color.White, onClick = {})
                CalculatorButton(symbol = "5", color = Color.White, onClick = {})
                CalculatorButton(symbol = "6", color = Color.White, onClick = {})
                CalculatorButton(symbol = "-", color = Color.Blue, onClick = {})
            }

            Row (horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                CalculatorButton(symbol = "1", color = Color.White, onClick = {})
                CalculatorButton(symbol = "2", color = Color.White, onClick = {})
                CalculatorButton(symbol = "3", color = Color.White, onClick = {})
                CalculatorButton(symbol = "+", color = Color.Blue, onClick = {})
            }
        }
    }
}

@Preview
@Composable
private fun Prev() {
    ButtonsSection()
}