package com.backend.practica10.demo.controller

import com.backend.practica10.demo.entity.Mascota
import com.backend.practica10.demo.model.Mmascota
import com.backend.practica10.demo.service.generateReportService
import com.backend.practica10.demo.service.mascotaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import reactor.netty.http.client.HttpClientResponse
import reactor.netty.http.server.HttpServerResponse
import java.net.http.HttpResponse
import java.util.logging.Logger
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/v1/mascotas")
class mascotaController {

    @Autowired
    @Qualifier("mascotaService")
    private lateinit var servicio: mascotaService;

    @Autowired
    @Qualifier("generateReportService")
    private lateinit var reportService :generateReportService ;

    var log : Logger = Logger.getGlobal();

    @PostMapping("/")
    fun agregarMascota(@RequestBody @Validated mascota: Mmascota): Mmascota {
        log.info("in the controller adding a mascota like: "+mascota.toString());
        return servicio.agregar(mascota);
    }

    @GetMapping("/all")
    fun obtenerMascotas(): List<Mmascota> {
        return servicio.obtenerMascotas();
    }

    @GetMapping("/report")
    fun generarReporte(response: HttpServletResponse) {
//        log.info("creating report");
        reportService.exportReport(response);
    }

    @PutMapping("/")
    fun actualizarMascota(@RequestBody @Validated mascota: Mmascota): Boolean {
        return servicio.actualizar(mascota);
    }

    @DeleteMapping("/{id}")
    fun deleteMascota( @PathVariable id: Int ) : Boolean {
     return servicio.eliminar(id);
    }


}