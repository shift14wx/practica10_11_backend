package com.backend.practica10.demo.entity.relations

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class MascotasKeyPk(
        @Column(name = "codigo_cliente")
        val codigo_cliente: Long,
        @Column(name = "codigo_especie")
        val codigo_especie: Long
) : Serializable{
}
