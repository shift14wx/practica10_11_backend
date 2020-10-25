package com.backend.practica10.demo.helpers

import com.backend.practica10.demo.entity.Cliente
import com.backend.practica10.demo.entity.Especie
import com.backend.practica10.demo.entity.Mascota
import com.backend.practica10.demo.model.MEspecie
import com.backend.practica10.demo.model.Mcliente
import com.backend.practica10.demo.model.Mmascota
import org.springframework.stereotype.Component

@Component("convertidor")
class convertidor {
    fun convertToMmascotasList(listMascotas: List<Mascota>): List<Mmascota> {
        return List(listMascotas.size, init = { index: Int -> Mmascota(listMascotas.get(index)) })
    }

    fun convertListMclientes(listClientes: List<Cliente>): List<Mcliente> {
        return List(listClientes.size, init = { index: Int -> Mcliente(listClientes.get(index)) })
    }

    fun convertirListToMEspecies(listEspecie: List<Especie>): List<MEspecie> {
        return List(listEspecie.size, init = { index: Int -> MEspecie(listEspecie.get(index)) })
    }
}