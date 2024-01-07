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
        val imageViewProduct: ImageView = itemView.findViewById(R.id.imageViewProducto)
        val textViewName: TextView = itemView.findViewById(R.id.textViewNombre)
        val textViewDescription: TextView = itemView.findViewById(R.id.textViewDescripcion)
        val textViewPrice: TextView = itemView.findViewById(R.id.textViewPrecio)

        fun bind(payModel: PayModel) {
            imageViewProduct.setImageResource(payModel.imgResId)
            textViewName.text = payModel.nom
            textViewDescription.text = payModel.descripcio
            textViewPrice.text = "Precio: $${payModel.preu}"
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
