package com.varma.hemanshu.mealzapp.ui.meals

import androidx.lifecycle.ViewModel
import com.varma.hemanshu.mealzapp.model.MealsRepository

class MealsCategoryViewModel(private val repository: MealsRepository = MealsRepository()) :
    ViewModel()