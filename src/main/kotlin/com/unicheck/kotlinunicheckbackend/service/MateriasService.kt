package com.unicheck.kotlinunicheckbackend.service

import com.unicheck.kotlinunicheckbackend.model.Materia
import com.unicheck.kotlinunicheckbackend.repository.MateriasRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MateriasService(@Autowired var materiasRepository: MateriasRepository){

     fun agregarMateria(materia: Materia): Materia{
        materiasRepository.save(materia)
        return materia
    }

    fun listarMaterias(): List<Materia>{
        return materiasRepository.findAll()
    }
}