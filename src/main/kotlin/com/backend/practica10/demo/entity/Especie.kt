package com.backend.practica10.demo.entity

import javax.persistence.*

@Entity
data class Especie(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val codigo_especie: Long,
        @Column(name = "especie")
        val especie: String,
        @OneToMany(mappedBy = "especie")
        val listaMascotas: List<Mascota> = ArrayList<Mascota>()
)