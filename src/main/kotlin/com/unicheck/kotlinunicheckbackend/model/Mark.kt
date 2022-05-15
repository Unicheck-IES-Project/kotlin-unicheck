package com.unicheck.kotlinunicheckbackend.model

import javax.persistence.*


@Entity
class Mark {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private val id : Long? = null
    private val title : String
    private val number : Float

    @ManyToOne(fetch = FetchType.LAZY)
    private val subject: Materia? = null

    companion object {
        fun withTitle(aTitle : String, aMarkNumber : Float) : Mark {
            if (aTitle.isBlank()) throw RuntimeException("El titulo de calificación no puede estar en blanco.")
            if (aMarkNumber < 1 || aMarkNumber > 10) throw RuntimeException("La nota numérica debe ser mayor a 0 y menor a 11.")
            return Mark(aTitle, aMarkNumber)
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
