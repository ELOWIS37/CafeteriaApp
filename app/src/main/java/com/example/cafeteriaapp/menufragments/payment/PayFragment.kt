package com.example.cafeteriaapp.menufragments.payment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeteriaapp.R
import com.example.cafeteriaapp.adapter.PayAdapter
import com.example.cafeteriaapp.viewmodel.PayViewModel
import com.example.cafeteriaapp.viewmodel.SharedViewModel

class PayFragment : Fragment() {

    private lateinit var sharedViewModel: SharedViewModel
    private lateinit var adapter: PayAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pay, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.payRecyclerView)

        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        adapter = PayAdapter(emptyList()) // Pasa una lista vacía inicialmente
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Observar los cambios en los elementos del carrito y actualizar el RecyclerView
        sharedViewModel.cartItems.observe(viewLifecycleOwner) { cartItems ->
            adapter.updateItems(cartItems)
        }

        // Observar el total y actualizar la interfaz de usuario
        sharedViewModel.totalAmount.observe(viewLifecycleOwner) { total ->
            // Actualizar la vista con el total a pagar
            // total es el total acumulado
        }

        return view
    }
}
