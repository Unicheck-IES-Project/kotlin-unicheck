package com.unicheck.kotlinunicheckbackend.service

import com.unicheck.kotlinunicheckbackend.model.Estudiante
import com.unicheck.kotlinunicheckbackend.model.Materia
import com.unicheck.kotlinunicheckbackend.repository.EstudianteRepository
import com.unicheck.kotlinunicheckbackend.repository.MateriasRepository
import com.unicheck.kotlinunicheckbackend.service.dtos.LoginDto
import com.unicheck.kotlinunicheckbackend.service.dtos.RegisterDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EstudianteService(@Autowired var estudianteRepository: EstudianteRepository){

    fun login(usuario: String, contraseña: String): Estudiante {
        var estudiante = estudianteRepository.findByNombreDeUsuario(usuario)
        if (!estudiante.estaIdentificadoConContraseña(contraseña)){
            throw java.lang.RuntimeException("Usuario o Contraseña incorrectos")
        }
        return estudiante
    }

    fun register(usuario: String, contraseña: String): Estudiante{
        if (estudianteRepository.findByNombreDeUsuario(usuario) != null){
            throw java.lang.RuntimeException("El nombre de usuario ya se encuentra en uso")
        }
        return estudianteRepository.save(Estudiante.identificadoCon(usuario,contraseña))
    }

    fun existeElEstudianteConLaId_(idUsuario: Long) : Boolean{
        var estudiante = estudianteRepository.findById(idUsuario).orElse(null)
        return  estudiante != null
    }
}