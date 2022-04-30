package com.unicheck.kotlinunicheckbackend.controller

import com.unicheck.kotlinunicheckbackend.model.Estudiante
import com.unicheck.kotlinunicheckbackend.model.Materia
import com.unicheck.kotlinunicheckbackend.repository.EstudianteRepository
import com.unicheck.kotlinunicheckbackend.service.EstudianteService
import com.unicheck.kotlinunicheckbackend.service.MateriasService
import com.unicheck.kotlinunicheckbackend.service.dtos.PeticionMateria
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/v1/subjects")
@CrossOrigin
class MateriasController {

    @Autowired
    private lateinit var materiasService: MateriasService

    @Autowired
    private lateinit var estudianteService: EstudianteService

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun agregarUnaMateria (@RequestBody peticion : PeticionMateria) : Estudiante {

        if (  estudianteService.existeElEstudianteConLaId_(peticion.idUsuario) ){
            try {
                val estudiante = materiasService.agregarMateria(peticion)
                return estudiante
            } catch(e: RuntimeException){
                throw ResponseStatusException(HttpStatus.BAD_REQUEST,e.message!!,e)
            }
        }
        throw java.lang.RuntimeException("El nombre de usuario no existe")
    }


    @GetMapping
    fun listaDeMateriasPara_(@RequestBody idEstudiante: Long) : Collection<Materia> {
           return materiasService.listarMateriasDe_(idEstudiante)
    }

}