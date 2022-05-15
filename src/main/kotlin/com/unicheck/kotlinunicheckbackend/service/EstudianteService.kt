package com.unicheck.kotlinunicheckbackend.service

import com.unicheck.kotlinunicheckbackend.exceptions.InvalidUsernameOrPasswordException
import com.unicheck.kotlinunicheckbackend.exceptions.StudentAlreadyExistsException
import com.unicheck.kotlinunicheckbackend.exceptions.StudentNotFoundException
import com.unicheck.kotlinunicheckbackend.model.Estudiante
import com.unicheck.kotlinunicheckbackend.repository.EstudianteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class EstudianteService(@Autowired var estudianteRepository: EstudianteRepository){

    fun login(unNombreDeUsuario: String, unaContraseña: String): Estudiante {
        var estudiante = estudianteRepository.findByNombreDeUsuario(unNombreDeUsuario).orElseThrow { StudentNotFoundException("No existe estudiante registrado con username dado.") }
        if (!estudiante.estaIdentificadoConContraseña(unaContraseña)){
            throw InvalidUsernameOrPasswordException("Usuario o Contraseña incorrectos")
        }
        return estudiante!!
    }

    fun registerStudentWith(anUsername: String, aPassword: String): Estudiante{
        if (estudianteRepository.findByNombreDeUsuario(anUsername).isPresent){
            throw StudentAlreadyExistsException("El nombre de usuario ya se encuentra en uso")
        }
        return estudianteRepository.save(Estudiante.identificadoCon(anUsername,aPassword))
    }

}