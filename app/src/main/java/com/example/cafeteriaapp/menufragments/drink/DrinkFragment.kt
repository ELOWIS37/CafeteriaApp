package com.example.cafeteriaapp.menufragments.drink

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeteriaapp.R
import com.example.cafeteriaapp.adapter.DrinkAdapter
import com.example.cafeteriaapp.viewmodel.DrinkViewModel
import com.example.cafeteriaapp.viewmodel.SharedViewModel

class DrinkFragment : Fragment() {

    private lateinit var drinkViewModel: DrinkViewModel
    private lateinit var sharedViewModel: SharedViewModel
    private lateinit var adapter: DrinkAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_drink, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.drinkRecyclerView)

        // Inicializar el DrinkViewModel
        drinkViewModel = ViewModelProvider(this).get(DrinkViewModel::class.java)

        // Inicializar el SharedViewModel
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        val drinkList = drinkViewModel.drinkLiveData.value ?: emptyList()

        adapter = DrinkAdapter(sharedViewModel, drinkList) { drink ->
            sharedViewModel.addDrinkToCart(drink)
        }

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        return view
    }
}