package com.android.learncompose.designPractice.challenge

import android.widget.RatingBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import com.android.learncompose.R


// TODO: Structure -> MainColumn -> TopRow -> Banner -> HeaderRow -> LazyRow -> HeaderRow -> Lazy Row
// LazyRow1Item: Column -> Box { Image + PriceTag } -> ItemName -> Row { ratingStar + count }


@Composable
fun EcommerceDay9Screen(modifier: Modifier = Modifier) {
    // Main column
    Column(modifier = Modifier.fillMaxSize()) {

        // Top row
        Row (modifier = Modifier.padding(16.dp)){
            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = {
                    Text("Search...")
                },
                trailingIcon = {
                    Icon(imageVector = Icons.Default.Search, contentDescription = null)
                },
                modifier = Modifier.weight(1f)
            )
            Spacer(Modifier.width(12.dp))
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Shopping cart")
            }
        }

        Spacer(Modifier.height(12.dp))

        Image(
            painter = painterResource(R.drawable.cake1),
            contentDescription = "Main banner",
            modifier = Modifier
                .height(120.dp)
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(10))
            , contentScale = ContentScale.FillBounds
        )

//        HeaderRow("Delicious Dopamine")

        DeliciousDopamineSection()
        TopGoodiesSection()
    }
}


@Composable
fun HeaderRow(title: String) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(
            title,
            fontWeight = FontWeight.Thin,
            fontSize = 20.sp,
            modifier = Modifier.weight(1f)
        )

        TextButton(onClick = {}) {
            Text("See all")
        }
    }
}

@Composable
fun DeliciousDopamineSection(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxWidth()) {
        HeaderRow("Delicious Dopamine")
        LazyRow (horizontalArrangement = Arrangement.spacedBy(12.dp), contentPadding = PaddingValues(16.dp)) {
            items(list) {
                DeliciousDopamineItem(it)
            }
        }
//        TODO("Lazy row in here")
    }
}

@Composable
fun DeliciousDopamineItem(item: DeliciousDopamineModel) {
    Column {
        Box(modifier = Modifier.size(100.dp)) {
            Image(painter = painterResource(item.image), contentDescription = null, modifier = Modifier
                .fillMaxSize()
                .clip(
                    RoundedCornerShape(10)
                ))
            Text("$${item.price}", color = Color.White, modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 8.dp, end = 8.dp)
                .background(Color.Blue))
        }
        Spacer(Modifier.height(8.dp))
        Text(item.label, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(4.dp))
        Row (horizontalArrangement = Arrangement.spacedBy(4.dp), verticalAlignment = Alignment.CenterVertically) {
            StarRating(item.rating)
            Text("(${item.ratingCount})", fontSize = 12.sp)
        }
    }
}

@Composable
fun TopGoodiesSection(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxWidth()) {
        HeaderRow("Top Goodies")
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(list) {
                TopGoodiesItem()
            }
        }
    }
}

@Composable
fun TopGoodiesItem(modifier: Modifier = Modifier) {
    Column (horizontalAlignment = Alignment.CenterHorizontally) {
        Card(
            modifier = Modifier.size(80.dp),
            elevation = CardDefaults.cardElevation(12.dp))
        {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(align = Alignment.Center)
                    .size(45.dp))
        }
        Spacer(Modifier.height(12.dp))
        Text("Label")
    }
}

@Composable
fun StarRating(rating: Int, maxStars: Int = 5) {
    Row {
        for (i in 1..maxStars) {
            Icon(
                imageVector = if (i <= rating) Icons.Filled.Star else Icons.Outlined.Star,
                contentDescription = "rating-star",
                tint = Color(0xFFFFD700), // Gold
                modifier = Modifier.size(12.dp)
            )
        }
    }
}


val list = List(10) {
    DeliciousDopamineModel(
        image = R.drawable.cake2,
        price = 10,
        label = "Cake 2",
        1,
        ratingCount = 1120
    )
}

@Preview (showBackground = true)
@Composable
private fun Day9Preview() {
    EcommerceDay9Screen()
}


// ============================ Model ===============================

data class DeliciousDopamineModel(
    val image: Int,
    val price: Int,
    val label: String,
    val rating: Int,
    val ratingCount: Int
)

















