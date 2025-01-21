package com.android.learncompose

import android.os.Bundle
import android.util.Log
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.learncompose.ui.theme.LearnComposeTheme
import kotlin.math.exp

class CodeLab1Activity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // call composable functions here
            LearnComposeTheme {
                // applies theme to this activity
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    var showOnBoardingState by rememberSaveable  { mutableStateOf(true) }
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        if(showOnBoardingState) {
            OnBoarding(onContinueClicked = { showOnBoardingState = false })
        } else {
            Greeting()
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier,  names: List<String> = List(100) { "$it" }) {
//        Column(modifier = modifier
//            .padding(vertical = 4.dp)
//            .background(Color.Red)) {
//            names.forEach {
//                GreetingCard(it)
//            }
//        }

    LazyColumn(
        modifier.padding(vertical = 4.dp)
    ) {
        items(items = names) { name ->
            GreetingCard(name)
        }
    }
}

@Composable
fun GreetingCard(name: String, modifier: Modifier = Modifier) {
    val expanded = rememberSaveable { mutableStateOf(false) }// internal state of this composable
    val extraPadding by animateDpAsState(
        if (expanded.value) 48.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )
    Surface(modifier = modifier
        .padding(vertical = 4.dp, horizontal = 8.dp)
        .fillMaxWidth(),
        color = MaterialTheme.colorScheme.primary){
        Row(modifier.padding(24.dp)) {
            Text (
                text = "Hello $name",
                modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
                    .align(Alignment.CenterVertically)
            )

            ElevatedButton(
                onClick = { expanded.value = !expanded.value }
            ) {
                Text(if (expanded.value) "Show less" else "show more")
            }
        }

    }
}

@Composable
fun OnBoarding(
    modifier: Modifier = Modifier,
    onContinueClicked:() -> Unit) {
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text("Welcome to this dummy app")
        ElevatedButton(
            onClick = { onContinueClicked() },
            modifier.padding(vertical = 24.dp)
        ){
            Text("Continue")
        }
    }
}

@Preview(showBackground = true, widthDp = 400, heightDp = 700)
@Composable
fun GreetingDemoPreview() {
//    MyApp()
    Greeting()
}

@Preview(showBackground = true, widthDp = 400, heightDp = 300)
@Composable
fun OnBoardingPreview() {
    OnBoarding(onContinueClicked = {})
}