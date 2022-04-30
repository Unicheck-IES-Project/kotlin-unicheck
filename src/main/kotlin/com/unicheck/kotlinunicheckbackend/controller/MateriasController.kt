package com.unicheck.kotlinunicheckbackend.controller

import com.unicheck.kotlinunicheckbackend.model.Materia
import com.unicheck.kotlinunicheckbackend.service.EstudianteService
import com.unicheck.kotlinunicheckbackend.service.MateriasService
import com.unicheck.kotlinunicheckbackend.service.dtos.SubjectCreationRequest
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
    fun registrarMateria (@PathVariable studentIdentifier : Long, @RequestBody request : SubjectCreationRequest) {
        try {
            materiasService.addSubjectToStudentIdentifiedBy(studentIdentifier, request)
        } catch(e: RuntimeException){
            throw ResponseStatusException(HttpStatus.BAD_REQUEST,e.message!!,e)
        }
    }


    @GetMapping
    fun materiasParaEstudianteIdentificadoCon(@PathVariable studentIdentifier : Long) : Collection<Materia> {
           return materiasService.subjectsOfStudentIdentifiedBy(studentIdentifier)
    }

}