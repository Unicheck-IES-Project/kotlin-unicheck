package com.unicheck.kotlinunicheckbackend.Controller

import com.unicheck.kotlinunicheckbackend.LogicaDeNegocio.Materia
import com.unicheck.kotlinunicheckbackend.Service.MateriasService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/v1/subjects")
class MateriasController {

    @Autowired
    private lateinit var materiasService: MateriasService


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun agregarUnaMateria (@RequestBody materia: Materia) : Materia {
        try {
            val materiaCreada = materiasService.agregarMateria(materia)
            return materiaCreada
        } catch(e: RuntimeException){
            throw ResponseStatusException(HttpStatus.BAD_REQUEST,e.message!!,e)
        }
    }

    @GetMapping
    fun listarMaterias(): List<Materia> {
        return materiasService.listarMaterias()
    }

}