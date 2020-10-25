package com.backend.practica10.demo.model

import com.backend.practica10.demo.entity.Cliente


data class Mcliente(val codigo_cliente: Long, val nombre: String, val correo: String, val telefono: String) {
    constructor(cliente: Cliente) : this(cliente.codigo_cliente, cliente.nombre, cliente.correo, cliente.telefono)
};
