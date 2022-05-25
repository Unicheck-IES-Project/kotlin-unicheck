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
        if (isValidFinalGrade(nota)) {
            this.notaFinal = nota
        }
        this.notas = ArrayList()
    }

    private fun isValidFinalGrade(grade: Float?): Boolean {
        return grade != null && grade > 0 && grade < 11
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    var id: Long? = null

    @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
    var notas : MutableList<Grade> = mutableListOf()

    var notaFinal : Float? = null

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
            this.notaFinal = null
        } else {
            if (nota != null) {
                this.notaFinal = nota
            }
        }
    }

    fun addGradeTitledAs(title: String, aGrade: Float): Grade {
        val grade = Grade.withTitle(title, aGrade)
        notas.add(grade)
        return grade
    }

    fun delete(aGrade: Grade) {
        if (notas.contains(aGrade)) {
            notas.remove(aGrade)
        }
    }

}