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
        // Aquí puedes inicializar tu lista de productos con los datos correspondientes
        _foodList.value = obtenirFood() // Deberías implementar esta función
    }

    fun afegirAlCarrito(model: FoodModel) {

    }

    private fun obtenirFood(): List<FoodModel> {
        // Aquí debes crear y devolver una lista de objetos Producto con diferentes datos
        // Por ejemplo:
        return listOf(
            FoodModel("Producto 1", "Descripción del Producto 1", 19.99, R.drawable.baseline_drink_beverage_24),
            FoodModel("Producto 2", "Descripción del Producto 2", 29.99, R.drawable.baseline_fastfood_24),
            FoodModel("Producto 3", "Descripción del Producto 3", 29.99, R.drawable.baseline_fastfood_24),
            FoodModel("Producto 4", "Descripción del Producto 4", 29.99, R.drawable.baseline_fastfood_24),
            FoodModel("Producto 5", "Descripción del Producto 5", 29.99, R.drawable.baseline_fastfood_24),
            FoodModel("Producto 6", "Descripción del Producto 6", 29.99, R.drawable.baseline_fastfood_24),
            FoodModel("Producto 7", "Descripción del Producto 7", 29.99, R.drawable.baseline_fastfood_24),
            FoodModel("Producto 8", "Descripción del Producto 8", 1129.99, R.drawable.baseline_fastfood_24),
            FoodModel("Producto 9", "Descripción del Producto 9", 129.99, R.drawable.baseline_fastfood_24),
            // ... Añade más productos con sus respectivos datos
        )
    }
}