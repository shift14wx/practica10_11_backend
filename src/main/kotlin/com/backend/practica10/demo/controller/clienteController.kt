package com.backend.practica10.demo.controller

import com.backend.practica10.demo.entity.Cliente
import com.backend.practica10.demo.model.Mcliente
import com.backend.practica10.demo.service.clienteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.logging.Logger

@RestController
@RequestMapping("/v1/clientes")
class clienteController {

    @Autowired
    @Qualifier("clienteService")
    private lateinit var servicio: clienteService;

    private var log: Logger = Logger.getGlobal();

    @PostMapping("/")
    fun agregarCliente(@RequestBody @Validated cliente: Cliente): Boolean {
        log.info("ingreso a agregar cliente en post!")
        return servicio.agregar(cliente);
    }

    @GetMapping("/")
    fun obtenerClientes(): List<Mcliente> {
        log.info("mostrando todos los clientes");
        return servicio.obtenerClientes();
    }

}