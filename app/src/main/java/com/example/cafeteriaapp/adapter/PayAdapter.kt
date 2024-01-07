package com.example.cafeteriaapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeteriaapp.R
import com.example.cafeteriaapp.menufragments.payment.PayModel

class PayAdapter(
    private var cartItems: List<PayModel>
) : RecyclerView.Adapter<PayAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewProducte: ImageView = itemView.findViewById(R.id.imageViewProducto)
        val textViewNom: TextView = itemView.findViewById(R.id.textViewNombre)
        val textViewDescripcio: TextView = itemView.findViewById(R.id.textViewDescripcion)
        val textViewPreu: TextView = itemView.findViewById(R.id.textViewPrecio)

        fun bind(payModel: PayModel) {
            imageViewProducte.setImageResource(payModel.imgResId)
            textViewNom.text = payModel.nom
            textViewDescripcio.text = payModel.descripcio
            textViewPreu.text = "Preu: ${payModel.preu}€"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cardview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = cartItems[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return cartItems.size
    }

    fun updateItems(newCartItems: List<PayModel>) {
        cartItems = newCartItems
        notifyDataSetChanged()
    }
}
