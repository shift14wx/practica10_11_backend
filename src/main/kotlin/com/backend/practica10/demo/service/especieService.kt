package com.backend.practica10.demo.service

import com.backend.practica10.demo.entity.Especie
import com.backend.practica10.demo.helpers.convertidor
import com.backend.practica10.demo.model.MEspecie
import com.backend.practica10.demo.repository.especieRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service("especieService")
class especieService {

    @Autowired
    @Qualifier("convertidor")
    private lateinit var convertidor: convertidor;

    @Autowired
    @Qualifier("especieRepository")
    private lateinit var repositorio: especieRepository;

    fun agregar(especie: Especie): Boolean {
        return checkIfEspecieIsValid(especie) { especie: Especie -> repositorio.save(especie) }
    }

    fun checkIfEspecieIsValid(especie: Especie, callback: (Especie) -> Unit): Boolean {
        try {
            callback(especie);
            return true;
        } catch (e: Exception) {
            return false;
        }
    }

    fun updateSpecie( especie: Especie ) : Boolean {
        return checkIfEspecieIsValid( especie, { especie: Especie -> repositorio.save(especie) } )
    }

    fun obtenerEspecies(): List<MEspecie> {
        return convertidor.convertirListToMEspecies(repositorio.findAll());
    }

}