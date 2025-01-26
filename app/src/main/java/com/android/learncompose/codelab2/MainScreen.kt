package com.android.learncompose.codelab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.learncompose.R
import com.android.learncompose.codelab2.components.AlignYourBodyElement
import com.android.learncompose.codelab2.components.FavoriteCollectionCard
import com.android.learncompose.designPractice.LoginScreen
import com.android.learncompose.designPractice.challenge.DialogComp
import com.android.learncompose.ui.theme.LearnComposeTheme

private val dataList = listOf(
    ItemData(label = "Label 1",drawable = R.drawable.ic_launcher_background),
    ItemData(label = "Label 2",drawable = R.drawable.ic_launcher_background),
    ItemData(label = "Label 3",drawable = R.drawable.ic_launcher_background),
    ItemData(label = "Label 4",drawable = R.drawable.ic_launcher_background),
    ItemData(label = "Label 5",drawable = R.drawable.ic_launcher_background),
    ItemData(label = "Label 6",drawable = R.drawable.ic_launcher_background),
    ItemData(label = "Label 7",drawable = R.drawable.ic_launcher_background)
)


class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    var showLogin by remember { mutableStateOf(true) } // hoisted state being triggered from HomeScreenContent

//    if (showLogin) {
//        LoginScreen(modifier, onLoginClick = { showLogin = false })
//    } else {
        HomeScreen(modifier, content = {
            HomeScreenContent(showDialog = {
                showLogin = true
            })
        })
//    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    var showDialog by remember { mutableStateOf(false) }
    if (showDialog) {
        DialogComp()
    }

//    HomeScreenContent()
}


@Composable
fun HomeScreenContent(modifier: Modifier = Modifier, showDialog: () -> Unit) {
    Surface(color = MaterialTheme.colorScheme.onPrimary,
        shape = MaterialTheme.shapes.extraLarge,
        modifier = modifier.fillMaxSize()) {
        Column  {
            SearchBar(Modifier.padding(horizontal = 12.dp))
            Text(
                "Align your body",
                modifier = Modifier
                    .paddingFromBaseline(top = 24.dp, bottom = 12.dp)
                    .padding(horizontal = 12.dp),
                style = MaterialTheme.typography.titleMedium)
            AlignYourBodyRow(data = dataList)
            Text(
                "Favorite card collection",
                modifier = Modifier
                    .paddingFromBaseline(top = 24.dp, bottom = 12.dp)
                    .padding(horizontal = 12.dp),
                style = MaterialTheme.typography.titleMedium)
            FavoriteCollectionGrid()
            ElevatedButton(
                onClick = { showDialog() },
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally).padding(top = 24.dp)
            ) {
                Text("Show dialog")
            }
        }
    }
}

@Composable
fun AlignYourBodyRow(modifier: Modifier = Modifier, data: List<ItemData> = listOf()) {
    LazyRow (
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(data) { item ->
            AlignYourBodyElement(drawable = item.drawable, label = item.label)
        }
    }
}


@Composable
fun FavoriteCollectionGrid(modifier: Modifier = Modifier) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.height(168.dp)
    ) {
        items(dataList) { item ->
            FavoriteCollectionCard(drawableRes = item.drawable, label = item.label)
        }
    }
}


@Preview(widthDp = 300, heightDp = 650)
@Composable
private fun Preview() {
//    AlignYourBodyRow(data = dataList)
    HomeScreen(content = {
        HomeScreenContent(showDialog = {

        })
    })
//    FavoriteCollectionGrid()
}


data class ItemData(
    val label: String,
    val drawable: Int
)