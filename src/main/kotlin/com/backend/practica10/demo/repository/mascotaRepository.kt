package com.backend.practica10.demo.repository

import com.backend.practica10.demo.entity.Mascota
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.io.Serializable

@Repository("mascotaRepository")
interface mascotaRepository : JpaRepository<Mascota, Serializable> {

}