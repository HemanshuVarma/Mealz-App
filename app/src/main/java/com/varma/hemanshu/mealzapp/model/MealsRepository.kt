package com.varma.hemanshu.mealzapp.model

import com.varma.hemanshu.mealzapp.model.api.MealsWebService
import com.varma.hemanshu.mealzapp.model.response.MealsCategoriesResponse

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {

    fun getMeals(): MealsCategoriesResponse? {
        return webService.getMeals().execute()
            .body() //execute will block main thread until it gets response
    }
}