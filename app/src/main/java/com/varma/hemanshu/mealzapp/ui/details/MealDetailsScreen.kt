package com.varma.hemanshu.mealzapp.ui.details

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.varma.hemanshu.mealzapp.model.response.MealResponse
import com.varma.hemanshu.mealzapp.ui.theme.MealzAppTheme

@Composable
fun MealDetailsScreen(meal: MealResponse?) {
    var isExpanded by remember { mutableStateOf(false) }
    val imageSizeDp: Dp by animateDpAsState(
        targetValue =
        if (isExpanded)
            200.dp
        else
            100.dp
    )

    Column {
        Row {
            Card {
                Image(
                    painter = rememberImagePainter(
                        data = meal?.imageUrl,
                        builder = {
                            transformations(CircleCropTransformation())
                        }),
                    contentDescription = "Meal image",
                    modifier = Modifier
                        .size(imageSizeDp)
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
        Button(onClick = {
            isExpanded = !isExpanded
        }) {
            Text(text = "Change Size")
        }
    }
}

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