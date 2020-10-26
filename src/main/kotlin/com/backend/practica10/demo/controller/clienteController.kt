package com.backend.practica10.demo.controller

import com.backend.practica10.demo.entity.Cliente
import com.backend.practica10.demo.model.Mcliente
import com.backend.practica10.demo.service.clienteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.MediaType
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import java.time.Duration
import java.util.*
import java.util.logging.Logger
import java.util.stream.Collectors
import java.util.stream.Stream
import javax.transaction.Transactional

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

//    @GetMapping("/reactive", produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
//    @Transactional
//    @ResponseBody
//    fun obtenerClientesReactive(): Flux<Mcliente> {
//
//           try {
//               var streamClientes: Stream<Cliente> = servicio.obtenerStreamClientes()
//               return Flux.fromStream(streamClientes).map { cliente: Cliente -> Mcliente( cliente ) }
//           }catch (e : Exception){
//                return Flux.interval( Duration.ofSeconds(1) ).map { Mcliente(1,"","","") }
//           }
//
//
//    }

    @GetMapping("/")
    fun obtenerClientes(): List<Mcliente> {
        log.info("mostrando todos los clientes");
        return servicio.obtenerClientes();
    }

}