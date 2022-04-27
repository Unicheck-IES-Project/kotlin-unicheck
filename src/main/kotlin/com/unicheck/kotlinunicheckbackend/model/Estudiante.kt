package com.unicheck.kotlinunicheckbackend.model

import java.util.*

class Estudiante {

    companion object {
        /*
        Objeto válido desde el primer momento.
        Constructor privado, único punto de entrada mediante validación.
         */
        fun identificadoCon(unNombreDeUsuario : String, unaContraseña : String) : Estudiante {
            StudentCreationValidator(unNombreDeUsuario, unaContraseña).validate()
            return Estudiante(unNombreDeUsuario, unaContraseña)
        }
    }

    private val nombreDeUsuario : String
    private val contraseña : String
    private val materias : MutableList<Materia>

    private constructor(unNombreDeUsuario : String, unaContraseña : String){
        nombreDeUsuario = unNombreDeUsuario
        contraseña = unaContraseña
        materias = mutableListOf()
    }

    fun materiasRegistradas() : Collection<Materia> {
        /*
         Principio de objetos inmutables. - ndemaio
         Según método #unmodifiableList, retorna una lista NO modificable.
         Al intentar hacer operaciones de escritura lanza excepción.
         Al retornar la lista tal cual, podriamos editar las materias desde afuera.
        */
        return Collections.unmodifiableList(materias)
    }

    fun registrar(unaMateria: Materia) {
        materias.add(unaMateria)
    }

    fun estaIdentificadoConContraseña(unaContraseñaAComparar: String): Boolean {
        return contraseña.equals(unaContraseñaAComparar)
    }

}