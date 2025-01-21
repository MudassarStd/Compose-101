package com.android.learncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.learncompose.ui.theme.LearnComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun SurveyQuestion(answers: List<Answer>) {
    Column {
        answers.forEach{ answer ->
            SurveyAnswer(answer)
        }
    }
}

@Composable
fun SurveyAnswer(answer: Answer) {
    Row(Modifier.padding(all = 8.dp)) {
        Text(answer.name, Modifier.padding(end = 8.dp))
        Text(answer.age.toString())
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearnComposeTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun SurveyAnswerPreview() {
    LearnComposeTheme {
        SurveyQuestion(listOf(
        Answer(name = "Alice", age = 30),
        Answer(name = "Bob", age = 25),
        Answer(name = "Charlie", age = 35),
        Answer(name = "Diana", age = 28),
        Answer(name = "Eve", age = 22)
        )
        )
    }
}


data class Answer(
    val name: String,
    val age: Int
)