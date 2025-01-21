package com.android.learncompose.design

import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onPlaced
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.learncompose.Greeting
import com.android.learncompose.ui.theme.LearnComposeTheme

class DesignPracticeActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent{
            LearnComposeTheme {
                MyApp2(Modifier.fillMaxSize())
            }
        }
    }
}


@Composable
fun MyApp2(modifier: Modifier = Modifier) {
    var showShowOnBoarding by remember { mutableStateOf(true) }
    if (showShowOnBoarding) {
        OnBoarding2(onContinueClicked = { showShowOnBoarding = false })
    } else {
        GreetingV2()
    }
}

@Composable
fun GreetingV2(modifier: Modifier = Modifier, names: List<String> = List(100) { "$it"}) {
    LazyColumn(modifier) {
        items(items = names) { name ->
            GreetingCard(name = name)
        }
    }
}

@Composable
fun GreetingCard(modifier: Modifier = Modifier, name: String) {
    var expanded by remember { mutableStateOf(false) }
    val dynamicPadding = if (expanded) 48.dp else 0.dp
    Surface(
        color = MaterialTheme.colorScheme.primary,
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp),
        shadowElevation = 8.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.padding(24.dp)
        ) {
            Column(
                modifier
                    .weight(1f)
                    .padding(start = 16.dp)
                    .padding(bottom = dynamicPadding)
            ) {
                Text("Hello")
                Text(name)
            }

            ElevatedButton(
                onClick = { expanded = !expanded}
            ) {
                Text(if (expanded) "Show less" else "show more")
            }
        }
    }
}


@Composable
fun OnBoarding2(modifier: Modifier = Modifier,
                onContinueClicked: () -> Unit) {
    Surface {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Welcome to this screen",
                modifier.padding(bottom = 12.dp),
                textDecoration = TextDecoration.Underline,
                fontStyle = FontStyle.Italic)
            ElevatedButton(
                onClick = {onContinueClicked()}
            ) {
                Text("Continue")
            }
        }
    }
}


//@Preview(showBackground = true, widthDp = 300, heightDp = 450)
//@Composable
//fun GreetingPreview(modifier: Modifier = Modifier) {
//    OnBoarding2 {  }
//}