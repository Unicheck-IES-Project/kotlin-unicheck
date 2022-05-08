package com.unicheck.kotlinunicheckbackend.controller

import com.unicheck.kotlinunicheckbackend.model.Materia
import com.unicheck.kotlinunicheckbackend.service.EstudianteService
import com.unicheck.kotlinunicheckbackend.service.MateriasService
import com.unicheck.kotlinunicheckbackend.service.dtos.SubjectCreationRequest
import com.unicheck.kotlinunicheckbackend.service.dtos.SubjectModificationRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/v1/{studentIdentifier}/subjects")
@CrossOrigin
class MateriasController {

    @Autowired
    private lateinit var materiasService: MateriasService

    @Autowired
    private lateinit var estudianteService: EstudianteService

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun registrarMateria (@PathVariable studentIdentifier : Long, @RequestBody request : SubjectCreationRequest) : Materia {
        try {
            val addedSubject = materiasService.addSubjectToStudentIdentifiedBy(studentIdentifier, request)
            return addedSubject
        } catch(e: RuntimeException){
            throw ResponseStatusException(HttpStatus.BAD_REQUEST,e.message!!,e)
        }
    }

    @GetMapping
    fun materiasParaEstudianteIdentificadoCon(@PathVariable studentIdentifier : Long) : Collection<Materia> {
           return materiasService.subjectsOfStudentIdentifiedBy(studentIdentifier)
    }

        //Tenemos que handlear el caso de bad request (malos datos en el form) de manera distinta a el 404, para separacion
        // de errores. En el sprint de manejo de errores, crear una excepcion acorde a cada caso.
    @PutMapping("/{subjectIdentifier}")
    @ResponseStatus(HttpStatus.OK)
    fun modifcarMateria(@PathVariable studentIdentifier: Long,@RequestBody request : SubjectModificationRequest,
                        @PathVariable subjectIdentifier : Long) : Materia {
        try {
            return materiasService.updateSubjectIdentifiedBy(request, subjectIdentifier)
        } catch (exception : RuntimeException){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, exception.message, exception)
        }
    }

    @DeleteMapping("/{subjectIdentifier}")
    @ResponseStatus(HttpStatus.OK)
    fun borrarMateria(@PathVariable studentIdentifier: Long, @PathVariable subjectIdentifier : Long) : Materia {
        try {
            return materiasService.deleteSubjectForStudentIdentifiedBy(studentIdentifier, subjectIdentifier)
        } catch (exception : RuntimeException){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, exception.message, exception)
        }
    }

}