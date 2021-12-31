package com.varma.hemanshu.mealzapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.varma.hemanshu.mealzapp.ui.meals.MealsCategoryScreen
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