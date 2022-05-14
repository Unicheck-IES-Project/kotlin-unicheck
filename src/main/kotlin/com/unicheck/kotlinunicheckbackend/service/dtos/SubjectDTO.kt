package com.unicheck.kotlinunicheckbackend.service.dtos

import com.unicheck.kotlinunicheckbackend.model.Estudiante
import com.unicheck.kotlinunicheckbackend.model.Materia


class SubjectDTO {

    var id: Long? = null
    var nota : Float? = null
    var nombre : String
    var periodoDeCursada:String
    var cursando:Boolean
    var añoDeCursada: Int
    var estudiante : Estudiante? = null

    constructor(aSubject : Materia) {
        this.nombre = aSubject.nombre
        this.periodoDeCursada = aSubject.periodoDeCursada
        this.cursando = aSubject.cursando
        if (aSubject.notas.isNotEmpty()) {
            this.nota = aSubject.notas.first().number()
        }
        this.añoDeCursada = aSubject.añoDeCursada
        this.id = aSubject.id
        this.estudiante = aSubject.estudiante
    }

}