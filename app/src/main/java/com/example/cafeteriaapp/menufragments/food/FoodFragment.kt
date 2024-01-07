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
import com.example.cafeteriaapp.viewmodel.SharedViewModel

class FoodFragment : Fragment() {

    private lateinit var foodViewModel: FoodViewModel
    private lateinit var sharedViewModel: SharedViewModel
    private lateinit var adapter: FoodAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_food, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.foodRecyclerView)

        foodViewModel = ViewModelProvider(this).get(FoodViewModel::class.java)

        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        val foodList = foodViewModel.foodLiveData.value ?: emptyList()

        adapter = FoodAdapter(sharedViewModel, foodList) { food ->
            sharedViewModel.addFoodToCart(food)
        }

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        return view
    }
}