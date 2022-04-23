package com.unicheck.kotlinunicheckbackend.Repository

import com.unicheck.kotlinunicheckbackend.LogicaDeNegocio.Materia
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface materiasRepository : JpaRepository<Materia, Long>  {}