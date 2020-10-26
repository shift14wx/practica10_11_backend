package com.backend.practica10.demo.repository

import com.backend.practica10.demo.entity.Cliente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.io.Serializable
import java.util.stream.Stream

@Repository("clienteRepository")
interface clienteRepository : JpaRepository<Cliente, Serializable> {
//    @Query("select codigo_cliente, nombre, correo, telefono from Cliente where Cliente.codigo_cliente = ?1", nativeQuery = true)
//    fun findByCodigoCliente( codigo_cliente : Long ) : Stream<Cliente>
//    @Query("select c from Cliente c")
//    fun findAllClientes( ) : Stream<Cliente>
}