package com.backend.practica10.demo.service

import com.backend.practica10.demo.entity.Mascota
import com.backend.practica10.demo.helpers.convertidor
import com.backend.practica10.demo.model.Mmascota
import com.backend.practica10.demo.repository.clienteRepository
import com.backend.practica10.demo.repository.especieRepository
import com.backend.practica10.demo.repository.mascotaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service("mascotaService")
class mascotaService {

    interface mascotaConsumer<T> {
        fun execute(callback: (T) -> Unit)
    }

    @Autowired
    @Qualifier("convertidor")
    private lateinit var conv: convertidor;

    @Autowired
    @Qualifier("mascotaRepository")
    lateinit var repositorio: mascotaRepository;

    @Autowired
    @Qualifier("clienteRepository")
    private lateinit var repositorioCliente: clienteRepository;

    @Autowired
    @Qualifier("especieRepository")
    private lateinit var repositorioEspecie: especieRepository;

    var log: Logger = Logger.getAnonymousLogger();

    fun obtenerMascotas(): List<Mmascota> {
        log.info("returning all the pets")
        return conv.convertToMmascotasList(repositorio.findAll());
    }

    fun eliminar(id: Int): Boolean {
        return checkIfModelsItsNotNull(repositorio.findById(id).get()) { m: Mascota -> repositorio.delete(m) }
    }

    fun agregar(mascotaAlmacenar: Mmascota): Boolean {
        var mascota: Mascota = Mascota(mascotaAlmacenar.codigo_mascota,
                mascotaAlmacenar.nombre,
                mascotaAlmacenar.fecha_nacimiento,
                mascotaAlmacenar.sexo, mascotaAlmacenar.peso,
                mascotaAlmacenar.color,
                mascotaAlmacenar.comentarios,
                repositorioCliente.findById(mascotaAlmacenar.codigo_cliente).get(),
                repositorioEspecie.findById(mascotaAlmacenar.codigo_especie).get()
        )
        return checkIfModelsItsNotNull(mascota) { mascota: Mascota -> repositorio.save(mascota) }

    }

    fun actualizar(mascotaAlmacenar: Mmascota): Boolean {

        var mascota: Mascota = Mascota(mascotaAlmacenar.codigo_mascota,
                mascotaAlmacenar.nombre,
                mascotaAlmacenar.fecha_nacimiento,
                mascotaAlmacenar.sexo, mascotaAlmacenar.peso,
                mascotaAlmacenar.color,
                mascotaAlmacenar.comentarios,
                repositorioCliente.findById(mascotaAlmacenar.codigo_cliente).get(),
                repositorioEspecie.findById(mascotaAlmacenar.codigo_especie).get()
        )

        return checkIfModelsItsNotNull(mascota) { mascota: Mascota -> repositorio.save(mascota) }

    }

    fun checkIfModelsItsNotNull(mascota: Mascota, consumer: (Mascota) -> Unit): Boolean {
        try {
            log.info("checking if the mascota class is right");
            consumer(mascota)
            return true;
        } catch (e: Exception) {
            log.warning("error its seems something went wrong")
            throw e;
            return false;
        }
    }

}