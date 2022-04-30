package com.unicheck.kotlinunicheckbackend.repository

import com.unicheck.kotlinunicheckbackend.model.Estudiante
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface EstudianteRepository : JpaRepository<Estudiante, Long> {
    fun findByNombreDeUsuario(nombre: String): Optional<Estudiante>

}