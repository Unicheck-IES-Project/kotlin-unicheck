package com.unicheck.kotlinunicheckbackend.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Materia(nombre:String,
              var periodoDeCursada:String,
              nota:Float,
              var cursando:Boolean,
              var añoDeCursada: Int){

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    var id: Long? = null
    var nota = chequearNota(nota)
    var nombre = chequearNombre(nombre)

    fun chequearNota(nota: Float) : Float{
        if (esUnaNotaInvalida(nota)){
            throw java.lang.RuntimeException("La nota debe estar comprendida entre los valores 1 y 10")
        }
        return nota
    }

    fun chequearNombre(nombre: String) : String {
        if (esUnCampoDeNombreInvalido(nombre)){
            throw java.lang.RuntimeException("El nombre no puede estar vacio")
        }
        return nombre
    }

    private fun esUnCampoDeNombreInvalido(nombre: String) = nombre.length == 0

    private fun esUnaNotaInvalida(nota: Float) = nota < 1f || nota > 10f


}