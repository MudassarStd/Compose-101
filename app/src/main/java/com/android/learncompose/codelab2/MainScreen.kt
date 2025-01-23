package com.android.learncompose.codelab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

                                    /*************************/
                                    /*** CONTINUE FROM HERE ***/
                                    /*************************/


//@Composable
//fun AlignYourBodyRow(modifier: Modifier = Modifier, list: List<Int>) {
//    LazyRow {
//        items(items = itemsList) { item ->
//            AlignYourBodyElement(item)
//        }
//    }
//}
//
//data class Item(
//    val label: String,
//    val drawable: Int
//)