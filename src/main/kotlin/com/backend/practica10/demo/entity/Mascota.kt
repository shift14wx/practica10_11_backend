package com.backend.practica10.demo.entity

import com.backend.practica10.demo.entity.relations.MascotasKeyPk
import com.backend.practica10.demo.entity.relations.MascotasKeysPk
import java.io.Serializable
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "mascotas")
data class Mascota(

//        @EmbeddedId
//        val id : MascotasKeysPk,
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val codigo_mascota: Long,
        @Column(name = "nombre")
        val nombre: String,
        @Column(name = "fecha_nacimiento")
        val fecha_nacimiento: Timestamp,
        @Column(name = "sexo")
        val sexo: Boolean,
        @Column(name = "peso")
        val peso: Float,
        @Column(name = "color")
        val color: String,
        @Column(name = "comentarios")
        val comentarios: String,
        @ManyToOne
        @JoinColumn(name = "codigo_cliente", nullable = false)
        val cliente: Cliente,
        @ManyToOne
        @JoinColumn(name = "codigo_especie", nullable = false)
        val especie: Especie

) : Serializable{
        override fun equals(other: Any?): Boolean {
                return super.equals(other)
        }

        override fun hashCode(): Int {
                return super.hashCode()
        }
}

