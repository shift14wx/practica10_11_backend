package com.backend.practica10.demo.repository

import com.backend.practica10.demo.entity.Cliente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.io.Serializable

@Repository("clienteRepository")
interface clienteRepository : JpaRepository<Cliente, Serializable> {

}