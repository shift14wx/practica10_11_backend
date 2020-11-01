package com.backend.practica10.demo.service

import com.backend.practica10.demo.entity.Cliente
import com.backend.practica10.demo.helpers.convertidor
import com.backend.practica10.demo.model.Mcliente
import com.backend.practica10.demo.repository.clienteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import java.util.logging.Logger
import java.util.stream.Stream

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

    fun agregar(cliente: Cliente): Cliente? {
        log.info("agregando el cliente con nombre ${cliente.nombre}")
        try {
            return repositorio.save(cliente);
        }catch (e: Exception){
            return null;
        }
    }

    fun eliminar( id: Int ) : Boolean{
        log.info("eliminar al cliente: "+ id);
        try {
            if( repositorio.findById( id.toLong() ).isPresent() ){
                repositorio.deleteById( id.toLong() )
                log.info("eliminado id "+ id);
            }else{
                log.warning("no se encotro nada");
            }
            return true;
        }catch( e: Exception ){
            return false;
        }
    }

    fun updateCliente( cliente : Cliente ) : Boolean {
        log.info("actualizando cliente nivel servicio");
        return checkIfClientIsValid(cliente) { cliente: Cliente -> repositorio.save(cliente) }
    }

    fun checkIfClientIsValid(cliente: Cliente, callback: (Cliente) -> Cliente): Boolean {
        try {
            callback(cliente);
            return true;
        } catch (e: Exception) {
            return false;
        }
    }

//    fun obtenerStreamClientes() : Stream<Cliente> {
//        return repositorio.findAllClientes();
//    }

}