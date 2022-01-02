package com.varma.hemanshu.mealzapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import com.varma.hemanshu.mealzapp.ui.meals.MealsCategoryScreen
import com.varma.hemanshu.mealzapp.ui.theme.MealzAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzAppTheme {
                Scaffold(topBar = { AppBar() }) {
                    MealsCategoryScreen()
                }
            }
        }
    }
}

@Composable
fun AppBar() {
    TopAppBar(
        title = {
            Text("Meals App")
        }
    )
}