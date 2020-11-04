package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.Gastos.Gasto
import com.example.recyclerview.Gastos.GastosAdapter

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), GastosAdapter.OnGastoClickListener {
    var listaGastos = getAllGastos()
    var adapter = GastosAdapter(listaGastos, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvGastos.adapter = adapter
        rvGastos.layoutManager  = LinearLayoutManager(this)
        rvGastos.setHasFixedSize(true)

    }


    //Retorna uma lista fixa de gastos
    fun getAllGastos(): ArrayList<Gasto>{
        val gasto1 = Gasto(1, "Uber", 15.00)
        val gasto2 = Gasto(2, "Passagem", 5.00)
        val gasto3 = Gasto(3, "Perdi na rua", 50.00)
        val gasto4 = Gasto(4, "Alimentação", 20.00)

        return arrayListOf(gasto1, gasto2, gasto3, gasto4)

    }

    override fun gastoClick(position: Int) {
        val gasto = listaGastos.get(position)
        gasto.descricao = "DEU CERTO"
        adapter.notifyItemChanged(position)
        Toast.makeText(this, gasto.toString(), Toast.LENGTH_SHORT).show()
    }
}