package com.android.learncompose.designPractice

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.learncompose.R

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
            .fillMaxSize()
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .padding(horizontal = 24.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = null,
                modifier = modifier
                    .clip(shape = CircleShape)
            )
            Text(
                text = "Kissan Ghar Login",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .paddingFromBaseline(top = 32.dp, bottom = 32.dp)
            )
            TextFieldComp(placeholderText = R.string.placeholder_email, leadingIcon = Icons.Default.Email)
            TextFieldComp(placeholderText = R.string.placeholder_password, leadingIcon = Icons.Default.AccountBox)

            ElevatedButton(
                onClick = {},
                modifier
                    .padding(vertical = 16.dp)
                    .fillMaxWidth()
            ) {
                Text("Login")
            }

            TextButton(
                onClick = {}
            ) {
                Text("New here? Sign up now")
            }
        }
    }
}

@Composable
fun TextFieldComp(
    modifier: Modifier = Modifier,
    @StringRes placeholderText: Int,
    leadingIcon: ImageVector) {

    var valueState by remember { mutableStateOf("") }

    TextField(
        value = valueState,
        onValueChange = {changedText ->
            valueState = changedText
        },
        leadingIcon = {
            Icon(
                imageVector = leadingIcon,
                contentDescription = null
            )
        },
        placeholder = {
            Text(stringResource(placeholderText))
        },
        modifier = modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
    )
}

@Preview
@Composable
private fun TFPreview() {

    LoginScreen()

//    TextFieldComp(
//        placeholderText = R.string.placeholder_search,
//        icon = Icons.Default.PlayArrow)
}