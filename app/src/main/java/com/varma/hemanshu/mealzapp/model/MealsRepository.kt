package com.varma.hemanshu.mealzapp.model

import com.varma.hemanshu.mealzapp.model.response.MealsCategoriesResponse

class MealsRepository {

    fun getMeals(): MealsCategoriesResponse {
        return MealsCategoriesResponse(arrayListOf())
    }
}