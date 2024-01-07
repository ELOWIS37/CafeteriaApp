package com.example.cafeteriaapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cafeteriaapp.R
import com.example.cafeteriaapp.menufragments.drink.DrinkModel

class DrinkViewModel : ViewModel(){
    private val _drinkList = MutableLiveData<List<DrinkModel>>()
    val drinkLiveData: LiveData<List<DrinkModel>>
        get() = _drinkList

    init {
        _drinkList.value = obtenirDrink()
    }

    private fun obtenirDrink(): List<DrinkModel> {
        return listOf(
            DrinkModel("Aigua", "Aigua natural o freda", 1.30, R.drawable.aigua),
            DrinkModel("Suc Natural", "Suc natural de taronja", 2.1, R.drawable.sucnatural),
            DrinkModel("Cervesa", "Cervesa refrescant", 2.3, R.drawable.cervesa),
        )
    }
}