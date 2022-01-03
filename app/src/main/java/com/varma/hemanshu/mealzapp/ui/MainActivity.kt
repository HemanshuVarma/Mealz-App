package com.varma.hemanshu.mealzapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.varma.hemanshu.mealzapp.ui.details.MealDetailsScreen
import com.varma.hemanshu.mealzapp.ui.details.MealDetailsViewModel
import com.varma.hemanshu.mealzapp.ui.meals.MealsCategoryScreen
import com.varma.hemanshu.mealzapp.ui.theme.MealzAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzAppTheme {
                Scaffold(topBar = { AppBar() }) {
                    MealzApp()
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

@Composable
fun MealzApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "destination_meals_list") {
        composable(route = "destination_meals_list") {
            MealsCategoryScreen { mealID ->
                navController.navigate("destination_meal_detail/$mealID")
            }
        }
        composable(
            route = "destination_meal_detail/{meal_category_id}",
            arguments = listOf(navArgument("meal_category_id") {
                type = NavType.StringType
            })
        ) {
            val viewModel: MealDetailsViewModel = viewModel()
            MealDetailsScreen(meal = viewModel.mealState.value)
        }
    }
}