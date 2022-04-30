package com.unicheck.kotlinunicheckbackend.service

import com.unicheck.kotlinunicheckbackend.model.Estudiante
import com.unicheck.kotlinunicheckbackend.model.Materia
import com.unicheck.kotlinunicheckbackend.repository.EstudianteRepository
import com.unicheck.kotlinunicheckbackend.repository.MateriasRepository
import com.unicheck.kotlinunicheckbackend.service.dtos.PeticionMateria
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MateriasService(@Autowired var materiasRepository: MateriasRepository,
                      @Autowired var estudianteRepository: EstudianteRepository){

     fun agregarMateria(peticion : PeticionMateria): Estudiante{
         var estudiante : Estudiante = estudianteRepository.findById(peticion.idUsuario).get()
         var materiaAAgregar =
             Materia(peticion.nombre,
                     peticion.periodoDeCursada,
                     peticion.cursando,
                     peticion.añoDeCursada,
                     peticion.nota,
                     estudiante)
         estudiante.registrar(materiaAAgregar)
         var estudianteConMateriaAgregada = estudianteRepository.save(estudiante)
         return estudianteConMateriaAgregada
    }

    fun listarMaterias(): List<Materia>{
        return materiasRepository.findAll()
    }

    fun listarMateriasDe_(idUsuario : Long) : Collection<Materia> {
        var estudiante : Estudiante = estudianteRepository.findById(idUsuario).get()
        return estudiante.materiasRegistradas()
    }
}