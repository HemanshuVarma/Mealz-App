package com.varma.hemanshu.mealzapp.ui.details

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.varma.hemanshu.mealzapp.model.response.MealResponse
import com.varma.hemanshu.mealzapp.ui.theme.MealzAppTheme
import java.lang.Float.min

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun MealDetailsScreen(meal: MealResponse?) {
    val scrollState = rememberScrollState()
    val offset = min(1f, 1 - (scrollState.value / 600f))
    val size by animateDpAsState(targetValue = max(100.dp, 200.dp * offset))

    Surface(color = MaterialTheme.colors.background) {
        Column {
            Surface(elevation = 4.dp) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Card(
                        modifier = Modifier.padding(16.dp),
                        shape = CircleShape,
                        border = BorderStroke(width = 2.dp, color = Color.Cyan)
                    ) {
                        Image(
                            painter = rememberImagePainter(
                                data = meal?.imageUrl,
                                builder = {
                                    transformations(CircleCropTransformation())
                                }),
                            contentDescription = "Meal image",
                            modifier = Modifier
                                .size(size)
                                .padding(8.dp)
                        )
                    }
                    Text(
                        text = meal?.name ?: "Meal Name",
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterVertically)
                    )
                }
            }
            Column(modifier = Modifier.verticalScroll(scrollState)) {
                Text(
                    text = "Hello World 1", modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = "Hello World 2", modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = "Hello World 3", modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = "Hello World 4", modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = "Hello World 5", modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = "Hello World 6", modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = "Hello World 7", modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = "Hello World 8", modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = "Hello World 9", modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = "Hello World 10", modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = "Hello World 11", modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = "Hello World 12", modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = "Hello World 13", modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = "Hello World 14", modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = "Hello World 15", modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.N)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    MealzAppTheme {
        MealDetailsScreen(
            meal = MealResponse(
                id = "1",
                name = "Dish Name",
                imageUrl = "https://www.themealdb.com/images/category/dessert.png",
                description = "Dummy Image for Preview"
            )
        )
    }
}