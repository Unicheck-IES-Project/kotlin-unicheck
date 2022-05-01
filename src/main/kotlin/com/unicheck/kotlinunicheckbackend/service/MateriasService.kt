package com.unicheck.kotlinunicheckbackend.service

import com.unicheck.kotlinunicheckbackend.model.Estudiante
import com.unicheck.kotlinunicheckbackend.model.Materia
import com.unicheck.kotlinunicheckbackend.repository.EstudianteRepository
import com.unicheck.kotlinunicheckbackend.repository.MateriasRepository
import com.unicheck.kotlinunicheckbackend.service.dtos.SubjectCreationRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class MateriasService(@Autowired var studentService: EstudianteService,
                      @Autowired var estudianteRepository: EstudianteRepository,
@Autowired private val materiasRepository: MateriasRepository){

     fun addSubjectToStudentIdentifiedBy(id : Long, peticion : SubjectCreationRequest) : Materia {
         var estudiante : Estudiante = estudianteRepository.findById(id).orElseThrow { RuntimeException("No existe usuario con ID dado.") }
         var materia = estudiante.registrarMateriaLlamada(
             peticion.nombre,
             peticion.periodoDeCursada,
             peticion.cursando,
             peticion.añoDeCursada,
             peticion.nota
         )
         var subject = materiasRepository.save(materia)
         estudianteRepository.save(estudiante)
         return subject
    }

    fun subjectsOfStudentIdentifiedBy(aStudentIdentifier : Long) : Collection<Materia> {
        return estudianteRepository.findById(aStudentIdentifier).get().materiasRegistradas()
    }
}