package com.backend.practica10.demo.controller

import com.backend.practica10.demo.entity.Mascota
import com.backend.practica10.demo.model.Mmascota
import com.backend.practica10.demo.service.mascotaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/mascotas")
class mascotaController {

    @Autowired
    @Qualifier("mascotaService")
    private lateinit var servicio: mascotaService;

    @PostMapping("/")
    fun agregarMascota(@RequestBody @Validated mascota: Mmascota): Boolean {
        return servicio.agregar(mascota);
    }

    @GetMapping("/all")
    fun obtenerMascotas(): List<Mmascota> {
        return servicio.obtenerMascotas();
    }

    @GetMapping(value = ["/"])
    fun hello(): String {
        return "Hola!! estas en la ruta de mascotas!";
    }

}