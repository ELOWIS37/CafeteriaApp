package com.example.cafeteriaapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cafeteriaapp.menufragments.payment.PayModel

class PayViewModel : ViewModel(){
    val llistaProductesSeleccionats = MutableLiveData<MutableList<PayModel>>()

    init {
        llistaProductesSeleccionats.value = mutableListOf()
    }

    fun afegirAlCarrito(payModel: PayModel) {
        val listaActual = llistaProductesSeleccionats.value ?: mutableListOf()
        listaActual.add(payModel)
        llistaProductesSeleccionats.value = listaActual
    }

    fun getLlistaProductesSeleccionats(): LiveData<MutableList<PayModel>> {
        return llistaProductesSeleccionats
    }

    fun eliminarDelCarrito(payModel: PayModel) {
        val listaActual = llistaProductesSeleccionats.value ?: mutableListOf()
        listaActual.remove(payModel)
        llistaProductesSeleccionats.value = listaActual
    }

    fun calcularTotal(): Double {
        val listaActual = llistaProductesSeleccionats.value ?: mutableListOf()
        return listaActual.sumByDouble { it.preu }
    }
}