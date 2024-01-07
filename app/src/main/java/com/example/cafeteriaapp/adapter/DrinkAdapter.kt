package com.example.cafeteriaapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeteriaapp.R
import com.example.cafeteriaapp.menufragments.drink.DrinkModel
import com.example.cafeteriaapp.menufragments.food.FoodModel
import com.example.cafeteriaapp.viewmodel.SharedViewModel

class DrinkAdapter(
    private val sharedViewModel: SharedViewModel,
    private val drinkList: List<DrinkModel>,
    private val onItemClickListener: (DrinkModel) -> Unit
) : RecyclerView.Adapter<DrinkAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewDrink: ImageView = itemView.findViewById(R.id.imageViewProducto)
        val textViewNom: TextView = itemView.findViewById(R.id.textViewNombre)
        val textViewDescripcio: TextView = itemView.findViewById(R.id.textViewDescripcion)
        val textViewPreu: TextView = itemView.findViewById(R.id.textViewPrecio)
        val btnAgregar: Button = itemView.findViewById(R.id.btnAgregar)

        fun bind(drinkModel: DrinkModel) {
            imageViewDrink.setImageResource(drinkModel.imgResId)
            textViewNom.text = drinkModel.nom
            textViewDescripcio.text = drinkModel.descripcio
            textViewPreu.text = "Preu: ${drinkModel.preu}€"

            btnAgregar.setOnClickListener {
                val drink = drinkList[adapterPosition]
                sharedViewModel.addDrinkToCart(drink)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cardview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = drinkList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return drinkList.size
    }
}