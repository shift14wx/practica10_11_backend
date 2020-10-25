package com.backend.practica10.demo.model

import com.backend.practica10.demo.entity.Especie


data class MEspecie(
        val codigo_especie: Long,
        val especie: String
) {
    constructor(especie: Especie) : this(especie.codigo_especie, especie.especie)
}