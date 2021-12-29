package com.varma.hemanshu.mealzapp.ui.meals

import androidx.lifecycle.ViewModel
import com.varma.hemanshu.mealzapp.model.MealsRepository
import com.varma.hemanshu.mealzapp.model.response.MealsCategoriesResponse

class MealsCategoryViewModel(private val repository: MealsRepository = MealsRepository()) :
    ViewModel() {

    fun getMeals(successCallback: (response: MealsCategoriesResponse?) -> Unit) {
        return repository.getMeals { response ->
            successCallback(response)
        }
    }
}