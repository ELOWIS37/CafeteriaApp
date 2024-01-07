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
        // TODO: Cambiar nombre variables
        val imageViewProducto: ImageView = itemView.findViewById(R.id.imageViewProducto)
        val textViewNombre: TextView = itemView.findViewById(R.id.textViewNombre)
        val textViewDescripcion: TextView = itemView.findViewById(R.id.textViewDescripcion)
        val textViewPrecio: TextView = itemView.findViewById(R.id.textViewPrecio)
        val btnAgregar: Button = itemView.findViewById(R.id.btnAgregar)

        fun bind(foodModel: FoodModel) {
            imageViewProducto.setImageResource(foodModel.imgResId)
            textViewNombre.text = foodModel.nom
            textViewDescripcion.text = foodModel.descripcio
            textViewPrecio.text = "Preu: ${foodModel.preu}€"

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
