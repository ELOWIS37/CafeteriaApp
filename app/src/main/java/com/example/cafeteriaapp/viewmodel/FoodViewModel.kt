package com.example.cafeteriaapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cafeteriaapp.R
import com.example.cafeteriaapp.menufragments.food.FoodModel
import com.example.cafeteriaapp.menufragments.payment.PayModel

class FoodViewModel : ViewModel() {
    private val _foodList = MutableLiveData<List<FoodModel>>()
    val foodLiveData: LiveData<List<FoodModel>>
        get() = _foodList

    init {
        _foodList.value = obtenirFood()
    }

    private fun obtenirFood(): List<FoodModel> {
        return listOf(
            FoodModel("Croissant", "Un deliciós croissant recentment fornit", 1.80, R.drawable.croissant),
            FoodModel("Sandvitx de pernil", "Sandvitx complet amb generoses porcions de pernil", 5.00, R.drawable.entrepapernil),
            FoodModel("Hamburguesa de vedella", "Hamburguesa clàssica de vedella", 7.5, R.drawable.hamburguesavedella),
            FoodModel("Mini burgers", "Ració per compartir de 5 mini burgers", 7.90, R.drawable.raciominiburgers),
            FoodModel("Hot dog", "Hot dog tradicional", 3.70, R.drawable.hotdog),
            FoodModel("Gelat", "Opció a triar entre xocolata o maduixa", 2.90, R.drawable.gelat)
        )
    }
}