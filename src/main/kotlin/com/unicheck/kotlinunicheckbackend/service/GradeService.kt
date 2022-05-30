package com.unicheck.kotlinunicheckbackend.service

import com.unicheck.kotlinunicheckbackend.exceptions.StudentNotFoundException
import com.unicheck.kotlinunicheckbackend.model.Grade
import com.unicheck.kotlinunicheckbackend.model.Materia
import com.unicheck.kotlinunicheckbackend.repository.GradeRepository
import com.unicheck.kotlinunicheckbackend.repository.MateriasRepository
import com.unicheck.kotlinunicheckbackend.service.dtos.GradeRegistrationRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GradeService(@Autowired var gradeRepository: GradeRepository, @Autowired var subjectRepository: MateriasRepository){

    fun addGradeToSubjectForStudentIdentifiedBy(subjectIdentifier: Long, request: GradeRegistrationRequest): Grade {
        val subject : Materia = subjectRepository.findById(subjectIdentifier).orElseThrow { StudentNotFoundException("No existe materia con ID dado.") }
        val createdGrade = subject.addGradeTitledAs(request.title, request.number)

        gradeRepository.save(createdGrade)
        return createdGrade
    }

    fun removeGradeOfSubjectForStudentIdentifiedBy(subjectIdentifier: Long, gradeIdentifier: Long): Grade {
        val subject : Materia = subjectRepository.findById(subjectIdentifier).orElseThrow { StudentNotFoundException("No existe materia con ID dado.") }
        val obtainedGrade = gradeRepository.findById(gradeIdentifier).orElseThrow { StudentNotFoundException("No existe calificacion con ID dado.") }

        subject.delete(obtainedGrade)

        gradeRepository.delete(obtainedGrade)
        return obtainedGrade
    }

}