package com.unicheck.kotlinunicheckbackend.service.dtos

import com.unicheck.kotlinunicheckbackend.model.Estudiante
import com.unicheck.kotlinunicheckbackend.model.Materia


class SubjectDTO {

    var id: Long? = null
    var notaFinal : Float? = null
    var nombre : String
    var periodoDeCursada:String
    var cursando:Boolean
    var notas:List<GradeDTO>
    var añoDeCursada: Int
    var estudiante : Estudiante? = null

    constructor(aSubject : Materia) {
        this.nombre = aSubject.nombre
        this.periodoDeCursada = aSubject.periodoDeCursada
        this.cursando = aSubject.cursando
        this.notaFinal = aSubject.notaFinal
        this.notas = aSubject.notas.map { grade -> GradeDTO(grade.id!!, grade.title(), grade.number(), grade.images.map { image -> ImageDTO(image.id!!, image.picture) }) }
        this.añoDeCursada = aSubject.añoDeCursada
        this.id = aSubject.id
        this.estudiante = aSubject.estudiante
    }

}