package com.unicheck.kotlinunicheckbackend.model

import javax.persistence.*


@Entity
class Grade {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    var id : Long? = null
    val title : String
    val number : Float

    @ManyToOne(fetch = FetchType.LAZY)
    private val subject: Materia? = null

    companion object {
        fun withTitle(aTitle : String, aMarkNumber : Float) : Grade {
            if (aTitle.isBlank()) throw RuntimeException("El titulo de calificación no puede estar en blanco.")
            if (aMarkNumber < 1 || aMarkNumber > 10) throw RuntimeException("La nota numérica debe ser mayor a 0 y menor a 11.")
            return Grade(aTitle, aMarkNumber)
        }
    }

    private constructor(aTitle: String, aMarkNumber: Float) {
        title = aTitle
        number = aMarkNumber
    }

    fun title():String {
        return title
    }
    fun number():Float {
        return number
    }
}
