package com.varma.hemanshu.mealzapp.ui.meals

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.varma.hemanshu.mealzapp.model.MealsRepository
import com.varma.hemanshu.mealzapp.model.response.MealResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MealsCategoryViewModel(private val repository: MealsRepository = MealsRepository()) :
    ViewModel() {

    private val mealsJob = Job()
    val mealsState: MutableState<List<MealResponse>> = mutableStateOf(emptyList())

    init {
        val scope = CoroutineScope(mealsJob + Dispatchers.IO)
        scope.launch {
            mealsState.value = getMeals()
        }

    }

    private suspend fun getMeals(): List<MealResponse> {
        return repository.getMeals().categories
    }

    override fun onCleared() {
        super.onCleared()
        mealsJob.cancel()
    }
}