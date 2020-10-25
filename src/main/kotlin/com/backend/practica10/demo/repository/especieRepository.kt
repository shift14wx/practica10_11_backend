package com.backend.practica10.demo.repository

import com.backend.practica10.demo.entity.Especie
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import java.io.Serializable

@Repository("especieRepository")
interface especieRepository : JpaRepository<Especie, Serializable>, PagingAndSortingRepository<Especie, Serializable> {

}