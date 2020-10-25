package com.backend.practica10.demo.service

import com.backend.practica10.demo.entity.Cliente
import com.backend.practica10.demo.helpers.convertidor
import com.backend.practica10.demo.model.Mcliente
import com.backend.practica10.demo.repository.clienteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service("clienteService")
class clienteService {

    @Autowired
    @Qualifier("clienteRepository")
    private lateinit var repositorio: clienteRepository;

    @Autowired
    @Qualifier("convertidor")
    private lateinit var convertidor: convertidor;

    private var log: Logger = Logger.getGlobal();

    fun obtenerClientes(): List<Mcliente> {
        return convertidor.convertListMclientes(repositorio.findAll());

    }

    fun agregar(cliente: Cliente): Boolean {
        log.info("agregando el cliente con nombre ${cliente.nombre}")
        return checkIfClientIsValid(cliente) { cliente: Cliente -> repositorio.save(cliente) };
    }

    fun checkIfClientIsValid(cliente: Cliente, callback: (Cliente) -> Cliente): Boolean {
        try {
            callback(cliente);
            return true;
        } catch (e: Exception) {
            return false;
        }
    }

}