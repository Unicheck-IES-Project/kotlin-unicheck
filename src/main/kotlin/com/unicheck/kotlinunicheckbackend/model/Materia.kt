package com.unicheck.kotlinunicheckbackend.model

import javax.persistence.*

@Entity
class Materia {

    constructor(unNombre:String, periodoDeCursada:String, cursando:Boolean, añoDeCursada: Int, nota:Float? = null, estudiante : Estudiante? = null) {
        if (unNombre.isBlank()) throw RuntimeException("El nombre no puede estar vacio")
        nombre = unNombre
        this.periodoDeCursada = periodoDeCursada
        this.cursando = cursando
        this.añoDeCursada = añoDeCursada
        this.estudiante = estudiante
        if (nota != null) {
            this.notas.add(Mark.withTitle("Nota final", nota))
        }
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    var id: Long? = null

    @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
    var notas : MutableList<Mark> = mutableListOf()

    var nombre : String

    var periodoDeCursada:String
    var cursando:Boolean
    var añoDeCursada: Int
    @ManyToOne(fetch = FetchType.LAZY)
    var estudiante : Estudiante? = null

    fun update(nombre: String, periodoDeCursada: String, cursando: Boolean, anioDeCursada: Int, nota: Float?) {
        this.nombre = nombre
        this.periodoDeCursada = periodoDeCursada
        this.cursando = cursando
        this.añoDeCursada = anioDeCursada

        if (cursando) {
            if (notas.isNotEmpty()) { notas.removeFirst() }
        } else {
            if (nota != null) {
                if (notas.isNotEmpty()) { notas.removeFirst() }
                this.notas.add(Mark.withTitle("Nota final", nota))
            }
        }
    }

}