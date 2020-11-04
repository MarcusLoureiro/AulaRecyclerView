package com.example.recyclerview.Gastos

class Gasto(val id: Int, var descricao: String, var valor: Double) {
    override fun toString(): String {
        return "Gastos(id=$id, descricao='$descricao', valor=$valor)"
    }
}