package com.example.cafeteriaapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeteriaapp.R
import com.example.cafeteriaapp.menufragments.food.FoodModel
import com.example.cafeteriaapp.viewmodel.SharedViewModel

class FoodAdapter(
    private val sharedViewModel: SharedViewModel,
    private var foodList: List<FoodModel>,
    private val onItemClickListener: (FoodModel) -> Unit
) : RecyclerView.Adapter<FoodAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewFood: ImageView = itemView.findViewById(R.id.imageViewProducto)
        val textViewNom: TextView = itemView.findViewById(R.id.textViewNombre)
        val textViewDescripcio: TextView = itemView.findViewById(R.id.textViewDescripcion)
        val textViewPreu: TextView = itemView.findViewById(R.id.textViewPrecio)
        val btnAgregar: Button = itemView.findViewById(R.id.btnAgregar)

        fun bind(foodModel: FoodModel) {
            imageViewFood.setImageResource(foodModel.imgResId)
            textViewNom.text = foodModel.nom
            textViewDescripcio.text = foodModel.descripcio
            textViewPreu.text = "Preu: ${foodModel.preu}€"

            btnAgregar.setOnClickListener {
                val food = foodList[adapterPosition]
                sharedViewModel.addFoodToCart(food)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cardview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = foodList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}
