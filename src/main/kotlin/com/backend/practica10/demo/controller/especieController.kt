package com.backend.practica10.demo.controller

import com.backend.practica10.demo.entity.Especie
import com.backend.practica10.demo.model.MEspecie
import com.backend.practica10.demo.service.especieService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.logging.Logger

@RestController
@RequestMapping("/v1/especie")
class especieController {

    var log : Logger = Logger.getGlobal();
    @Autowired
    @Qualifier("especieService")
    private lateinit var servicio: especieService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    fun agregarEspecie(@RequestBody @Validated especie: Especie): Boolean {
        return servicio.agregar(especie);
    }

    @PutMapping("/")
    fun updateEspecie( @RequestBody @Validated specie: Especie ) : Boolean{
        return servicio.updateSpecie( specie )
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    fun obtenerEspecies(): List<MEspecie> {
        log.info("getting all especies");
        return servicio.obtenerEspecies();
    }

}