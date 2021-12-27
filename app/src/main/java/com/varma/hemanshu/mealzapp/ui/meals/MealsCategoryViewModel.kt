package com.varma.hemanshu.mealzapp.ui.meals

import androidx.lifecycle.ViewModel
import com.varma.hemanshu.mealzapp.model.MealsRepository
import com.varma.hemanshu.mealzapp.model.response.MealResponse

class MealsCategoryViewModel(private val repository: MealsRepository = MealsRepository()) :
    ViewModel() {

    fun getMeals(): List<MealResponse> {
        return repository.getMeals().categories
    }
}