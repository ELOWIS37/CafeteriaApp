package com.example.cafeteriaapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cafeteriaapp.R
import com.example.cafeteriaapp.menufragments.food.FoodModel

class FoodViewModel : ViewModel() {
    private val _foodList = MutableLiveData<List<FoodModel>>()
    val foodLiveData: LiveData<List<FoodModel>>
        get() = _foodList

    init {
        // Aquí puedes inicializar tu lista de productos con los datos correspondientes
        _foodList.value = obtenerProductos() // Deberías implementar esta función
    }

    fun agregarAlCarrito(model: FoodModel) {
        // Aquí puedes realizar las acciones necesarias al agregar al carrito
        // Por ejemplo, puedes guardar el producto en una lista de productos en el ViewModel
    }

    private fun obtenerProductos(): List<FoodModel> {
        // Aquí debes crear y devolver una lista de objetos Producto con diferentes datos
        // Por ejemplo:
        return listOf(
            FoodModel("Producto 1", "Descripción del Producto 1", 19.99, R.drawable.baseline_drink_beverage_24),
            FoodModel("Producto 2", "Descripción del Producto 2", 29.99, R.drawable.baseline_fastfood_24),
            // ... Añade más productos con sus respectivos datos
        )
    }
}