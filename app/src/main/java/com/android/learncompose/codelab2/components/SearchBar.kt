package com.android.learncompose.codelab2

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.learncompose.R



// how TextField value state is working
// when we type in anything, onValueChange(text: String) is called
// now we have onValueChange{} implemented here in TextField, this is called on typing text
// we take onValueChange{text -> stateValue = text}, we pass this changed value to state, then that state is being set to actual value of TextField


// whenever the value of state is changed, comp is recomposed

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    var value by remember { mutableStateOf("") }            // interval value state for TextField

    TextField(
        value = value,
        onValueChange = {v ->
            value = v },
        leadingIcon = {                                     // leadingIcon is lambda function that calls another function in its body (Icon comp)
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )},
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.surfaceContainer,
            focusedContainerColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        placeholder = {                                     // placeholder is lambda function that calls another function in its body (Text comp)
            Text(stringResource(R.string.placeholder_search))
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
    )
}


@Preview
@Composable
fun SearchBarPreview(modifier: Modifier = Modifier) {
    SearchBar()
}

