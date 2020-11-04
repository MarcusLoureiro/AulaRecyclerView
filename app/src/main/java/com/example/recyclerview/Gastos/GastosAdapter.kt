package com.example.recyclerview.Gastos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R


class GastosAdapter(private var listGastos: ArrayList<Gasto>, val listener: OnGastoClickListener): RecyclerView.Adapter<GastosAdapter.GastosViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GastosAdapter.GastosViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_gasto, parent, false)
        return GastosViewHolder(itemView)
    }

    override fun getItemCount() = listGastos.size


    override fun onBindViewHolder(holder: GastosAdapter.GastosViewHolder, position: Int) {
       var gasto = listGastos.get(position)

        holder.tvDecricao.text = gasto.descricao
    }

    interface OnGastoClickListener{
         fun gastoClick(position: Int)

    }

    inner class GastosViewHolder(itemView: View):RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val tvDecricao: TextView = itemView.findViewById(R.id.tvDescricao)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?){
            val position = adapterPosition
            if(RecyclerView.NO_POSITION != position){
                listener.gastoClick(position)
            }
        }
    }
}