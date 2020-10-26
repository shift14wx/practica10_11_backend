package com.backend.practica10.demo.entity

import javax.persistence.*

@Entity
@Table(name = "cliente")
data class Cliente(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val codigo_cliente: Long,
        @Column(name = "nombre")
        val nombre: String,
        @Column(name = "correo")
        val correo: String,
        @Column(name = "telefono")
        val telefono: String,
        @OneToMany(mappedBy = "cliente")
        val listaMascotas: List<Mascota> = ArrayList<Mascota>()

) {
        override fun toString(): String {
                return "{nombre:${this.nombre}, correo: ${this.correo}, codigo_cliente:${this.codigo_cliente}, telefono:${this.telefono}}";
        }
}