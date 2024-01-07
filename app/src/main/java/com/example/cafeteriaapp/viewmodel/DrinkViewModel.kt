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
        // Aquí puedes inicializar tu lista de productos con los datos correspondientes
        _drinkList.value = obtenirDrink() // Deberías implementar esta función
    }

    fun agregarAlCarrito(model: DrinkModel) {
        // Aquí puedes realizar las acciones necesarias al agregar al carrito
        // Por ejemplo, puedes guardar el producto en una lista de productos en el ViewModel
    }

    private fun obtenirDrink(): List<DrinkModel> {
        // Aquí debes crear y devolver una lista de objetos Producto con diferentes datos
        // Por ejemplo:
        return listOf(
            DrinkModel("Producto 1", "Descripción del Producto 1", 19.99, R.drawable.baseline_fastfood_24),
            DrinkModel("Producto 2", "Descripción del Producto 2", 29.99, R.drawable.baseline_drink_beverage_24),
            DrinkModel("Producto 3", "Descripción del Producto 3", 23.99, R.drawable.baseline_credit_card_24),
            // ... Añade más productos con sus respectivos datos
        )
    }
}