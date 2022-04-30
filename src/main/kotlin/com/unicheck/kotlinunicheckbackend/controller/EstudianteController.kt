package com.unicheck.kotlinunicheckbackend.controller

import com.unicheck.kotlinunicheckbackend.service.EstudianteService
import com.unicheck.kotlinunicheckbackend.service.dtos.EstudianteDto
import com.unicheck.kotlinunicheckbackend.service.dtos.LoginDto
import com.unicheck.kotlinunicheckbackend.service.dtos.StudentRegistrationDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/v1/authenticate/students")
@CrossOrigin
class EstudianteController {

    @Autowired
    private lateinit var estudianteService: EstudianteService

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun registrarEstudiante (@RequestBody studentRegistrationDTO: StudentRegistrationDTO) : EstudianteDto {
        try {
            val estudianteCreado = estudianteService.registerStudentWith(studentRegistrationDTO.username, studentRegistrationDTO.password)
            return EstudianteDto(estudianteCreado)
        } catch(exception: RuntimeException){
            throw ResponseStatusException(HttpStatus.BAD_REQUEST,exception.message!!,exception)
        }
    }

    @GetMapping
    fun login(@RequestBody loginDto: LoginDto) : EstudianteDto  {
        try {
            var estudianteLogueado = estudianteService.login(loginDto.username, loginDto.password)
            return EstudianteDto(estudianteLogueado)
        } catch(exception: java.lang.RuntimeException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, exception.message!!, exception)
        }
    }
}