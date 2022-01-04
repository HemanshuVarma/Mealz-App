package com.varma.hemanshu.mealzapp.ui.details

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.varma.hemanshu.mealzapp.model.response.MealResponse
import com.varma.hemanshu.mealzapp.ui.theme.MealzAppTheme

@Composable
fun MealDetailsScreen(meal: MealResponse?) {
    var profilePictureState by remember { mutableStateOf(ProfileState.Normal) }
    val transition = updateTransition(targetState = profilePictureState, label = "")
    val imageSizeDp by transition.animateDp(targetValueByState = { it.size }, label = "")
    val color by transition.animateColor(targetValueByState = { it.color }, label = "")
    val borderWidth by transition.animateDp(targetValueByState = { it.borderWidth }, label = "")

    Column {
        Row {
            Card(
                modifier = Modifier.padding(16.dp),
                shape = CircleShape,
                border = BorderStroke(width = borderWidth, color = color)
            ) {
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
            profilePictureState = if (profilePictureState == ProfileState.Normal)
                ProfileState.Expanded
            else
                ProfileState.Normal
        }) {
            Text(text = "Change Size")
        }
    }
}

enum class ProfileState(val color: Color, val size: Dp, val borderWidth: Dp) {
    Normal(color = Color.Cyan, size = 120.dp, borderWidth = 8.dp),
    Expanded(color = Color.Blue, size = 200.dp, borderWidth = 16.dp)
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