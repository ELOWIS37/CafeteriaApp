package com.example.cafeteriaapp.menufragments.food

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeteriaapp.R
import com.example.cafeteriaapp.adapter.FoodAdapter
import com.example.cafeteriaapp.viewmodel.FoodViewModel

class FoodFragment : Fragment() {

    private lateinit var foodViewModel: FoodViewModel
    private lateinit var adapter: FoodAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_food, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.foodRecyclerView)

        // Inicializar el ViewModel
        foodViewModel = ViewModelProvider(this).get(FoodViewModel::class.java)

        // Obtener la lista de productos desde el ViewModel
        val productList = foodViewModel.foodLiveData.value ?: emptyList()

        // Inicializar el adaptador con la lista de productos y el listener para el botón
        adapter = FoodAdapter(productList) { producto ->
            foodViewModel.agregarAlCarrito(producto)
            // Aquí puedes realizar acciones adicionales al agregar al carrito, si es necesario
        }

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        return view
    }
}