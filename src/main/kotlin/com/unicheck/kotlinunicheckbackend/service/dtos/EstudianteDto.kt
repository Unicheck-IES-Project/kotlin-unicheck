package com.unicheck.kotlinunicheckbackend.service.dtos

import com.unicheck.kotlinunicheckbackend.model.Estudiante
import com.unicheck.kotlinunicheckbackend.model.Materia

class EstudianteDto(estudiante: Estudiante) {
    var nombreDeUsuario = estudiante.getNombre()
    var id = estudiante.getId()
    var materias = estudiante.materiasRegistradas().map { subject -> SubjectDTO(subject) }
}