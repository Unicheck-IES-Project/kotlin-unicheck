package com.unicheck.kotlinunicheckbackend.repository

import com.unicheck.kotlinunicheckbackend.model.Materia
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MateriasRepository : JpaRepository<Materia, Long>  {}