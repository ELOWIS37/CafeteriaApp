package com.example.cafeteriaapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cafeteriaapp.menufragments.drink.DrinkModel
import com.example.cafeteriaapp.menufragments.food.FoodModel
import com.example.cafeteriaapp.menufragments.payment.PayModel

class SharedViewModel : ViewModel() {
    private val _cartItems = MutableLiveData<List<PayModel>>()
    val cartItems: LiveData<List<PayModel>> = _cartItems

    private val _totalAmount = MutableLiveData<Double>()
    val totalAmount: LiveData<Double> = _totalAmount

    init {
        _cartItems.value = mutableListOf()
        _totalAmount.value = 0.0
    }

    fun addFoodToCart(food: FoodModel) {
        val currentCart = _cartItems.value?.toMutableList() ?: mutableListOf()
        val payModel = PayModel(food.nom, food.descripcio, food.preu, food.imgResId)
        currentCart.add(payModel)
        _cartItems.value = currentCart

        _totalAmount.value = (_totalAmount.value ?: 0.0) + food.preu
    }

    fun addDrinkToCart(drink: DrinkModel) {
        val currentCart = _cartItems.value?.toMutableList() ?: mutableListOf()
        val payModel = PayModel(drink.nom, drink.descripcio, drink.preu, drink.imgResId)
        currentCart.add(payModel)
        _cartItems.value = currentCart

        _totalAmount.value = (_totalAmount.value ?: 0.0) + drink.preu
    }

    fun resetCart() {
        _cartItems.value = mutableListOf()
        _totalAmount.value = 0.0
    }
}