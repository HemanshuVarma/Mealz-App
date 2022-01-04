package com.varma.hemanshu.mealzapp.ui.meals

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.varma.hemanshu.mealzapp.model.response.MealResponse
import com.varma.hemanshu.mealzapp.ui.theme.MealzAppTheme

@Composable
fun MealsCategoryScreen(clickCallback: (String) -> Unit) {
    //singleton init with the help of ViewModel Lifecycle
    val viewModel = viewModel<MealsCategoryViewModel>()
    val meals = viewModel.mealsState.value

    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        items(meals) { meal ->
            Meal(meal = meal, clickCallback)
        }
    }
}

@Composable
fun Meal(meal: MealResponse, clickCallback: (String) -> Unit) {
    var isExpanded by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .clickable { clickCallback(meal.id) }
    ) {
        Row(Modifier.animateContentSize()) {
            Image(
                painter = rememberImagePainter(meal.imageUrl),
                contentDescription = "Meal image",
                modifier = Modifier
                    .size(88.dp)
                    .padding(4.dp)
                    .align(Alignment.CenterVertically)
            )
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp)
                    .fillMaxWidth(0.8f)
            ) {
                Text(text = meal.name, style = MaterialTheme.typography.h6)
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.disabled) {
                    Text(
                        text = meal.description,
                        textAlign = TextAlign.Justify,
                        style = MaterialTheme.typography.subtitle2,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = if (isExpanded) 20 else 4
                    )
                }
            }

            Icon(
                imageVector = if (isExpanded)
                    Icons.Filled.KeyboardArrowUp
                else
                    Icons.Filled.KeyboardArrowDown,
                contentDescription = "Icon for Expanding/Collapsing description",
                modifier = Modifier
                    .padding(16.dp)
                    .align(
                        if (isExpanded)
                            Alignment.Bottom
                        else
                            Alignment.CenterVertically
                    )
                    .clickable { isExpanded = !isExpanded }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    MealzAppTheme {
        MealsCategoryScreen { }
    }
}