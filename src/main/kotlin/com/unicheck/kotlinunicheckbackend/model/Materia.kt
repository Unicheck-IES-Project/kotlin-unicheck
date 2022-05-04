package com.unicheck.kotlinunicheckbackend.model

import javax.persistence.*

@Entity
class Materia(nombre:String,
              var periodoDeCursada:String,
              var cursando:Boolean,
              var añoDeCursada: Int,
              nota:Float? = null,
              @ManyToOne(fetch = FetchType.LAZY)
              var estudiante : Estudiante? = null){

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    var id: Long? = null

    @Column(nullable = true)
    var nota = chequearNota(nota)

    var nombre = chequearNombre(nombre)


    fun chequearNota(nota: Float?) : Float?{
        if ( !(esUnaNotaValida(nota)) ){
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

    private fun esUnaNotaInvalida(nota: Float) =  nota < 1f || nota > 10f

    private fun esUnaNotaValida(nota : Float?) = nota == null || !(esUnaNotaInvalida(nota!!))
    fun update(nombre: String, periodoDeCursada: String, cursando: Boolean, añoDeCursada: Int, nota: Float?) {
        this.nombre = chequearNombre(nombre)
        this.periodoDeCursada = periodoDeCursada
        this.cursando = cursando
        this.añoDeCursada = añoDeCursada
        var notaCorrespondiente =
            if (cursando) {
                null
            } else {
                nota
            }
        this.nota = chequearNota(notaCorrespondiente)
    }

}