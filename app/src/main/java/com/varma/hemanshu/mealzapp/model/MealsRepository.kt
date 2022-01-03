package com.varma.hemanshu.mealzapp.model

import com.varma.hemanshu.mealzapp.model.api.MealsWebService
import com.varma.hemanshu.mealzapp.model.response.MealResponse
import com.varma.hemanshu.mealzapp.model.response.MealsCategoriesResponse

class MealsRepository(private val webService: MealsWebService) {

    private var cachedMeals = listOf<MealResponse>()

    suspend fun getMeals(): MealsCategoriesResponse {
        val mealResponse = webService.getMeals()
        cachedMeals = mealResponse.categories
        return mealResponse
    }

    fun getMeal(id: String): MealResponse? {
        return cachedMeals.firstOrNull { meal ->
            meal.id == id
        }
    }

    companion object {
        @Volatile
        private var instance: MealsRepository? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: MealsRepository(MealsWebService()).also { instance = it }
        }
    }
}