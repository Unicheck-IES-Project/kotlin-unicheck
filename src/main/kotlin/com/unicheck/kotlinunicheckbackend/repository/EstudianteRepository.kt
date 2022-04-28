package com.unicheck.kotlinunicheckbackend.repository

import com.unicheck.kotlinunicheckbackend.model.Estudiante
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EstudianteRepository : JpaRepository<Estudiante, Long> {}