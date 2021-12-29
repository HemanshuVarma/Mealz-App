package com.varma.hemanshu.mealzapp.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.varma.hemanshu.mealzapp.model.response.MealResponse
import com.varma.hemanshu.mealzapp.ui.theme.MealzAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzAppTheme {
                MealsCategoryScreen()
            }
        }
    }
}

@Composable
fun MealsCategoryScreen() {
    //singleton init with the help of ViewModel Lifecycle
    val viewModel = viewModel<MealsCategoryViewModel>()
    val rememberedMealsList = remember {
        mutableStateOf<List<MealResponse>>(emptyList())
    }

    viewModel.getMeals { response ->
        // Returns list of meal categories OR empty list when no response
        rememberedMealsList.value = response?.categories.orEmpty()
    }

    LazyColumn {
        items(rememberedMealsList.value) { meal ->
            Text(text = meal.category)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealzAppTheme {
        MealsCategoryScreen()
    }
}