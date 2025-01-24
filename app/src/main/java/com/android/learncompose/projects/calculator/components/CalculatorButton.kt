package com.android.learncompose.projects.calculator.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

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

    Box(
        modifier = Modifier
            .clip(CircleShape)
            .then(modifier),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = symbol
        )
    }
}