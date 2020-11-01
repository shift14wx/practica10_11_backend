package com.backend.practica10.demo.model

import com.backend.practica10.demo.entity.Mascota
import java.sql.Timestamp

data class Mmascota(
        var codigo_mascota: Long,
        var nombre: String,
        var fecha_nacimiento: Timestamp,
        var sexo: Boolean,
        var peso: Float,
        var color: String,
        var comentarios: String,
        var codigo_cliente: Long,
        var codigo_especie: Long,
        var cliente : String = "",
        var especie : String = ""
) {
    constructor(mascota: Mascota) : this(mascota.codigo_mascota, mascota.nombre, mascota.fecha_nacimiento, mascota.sexo, mascota.peso, mascota.color, mascota.comentarios, mascota.cliente.codigo_cliente, mascota.especie.codigo_especie,mascota.cliente.nombre, mascota.especie.especie)
}

