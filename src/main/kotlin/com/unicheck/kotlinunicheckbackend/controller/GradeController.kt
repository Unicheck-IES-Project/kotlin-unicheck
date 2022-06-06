package com.unicheck.kotlinunicheckbackend.controller

import com.unicheck.kotlinunicheckbackend.model.Grade
import com.unicheck.kotlinunicheckbackend.service.GradeService
import com.unicheck.kotlinunicheckbackend.service.dtos.GradeDTO
import com.unicheck.kotlinunicheckbackend.service.dtos.GradeRegistrationRequest
import com.unicheck.kotlinunicheckbackend.service.dtos.ImageDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.server.ResponseStatusException

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/v1/{subjectIdentifier}/grade")
@CrossOrigin
class GradeController {

    @Autowired
    private lateinit var gradeService: GradeService

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addGradeToSubjectForStudentIdentifiedBy (@PathVariable subjectIdentifier : Long, @RequestBody request : GradeRegistrationRequest) : Grade {
        try {
            return gradeService.addGradeToSubjectForStudentIdentifiedBy(subjectIdentifier, request);
        } catch(e: RuntimeException){
            throw ResponseStatusException(HttpStatus.BAD_REQUEST,e.message!!,e)
        }
    }

    @DeleteMapping("/{gradeIdentifier}")
    @ResponseStatus(HttpStatus.OK)
    fun removeGradeOfSubjectForStudentIdentifiedBy(@PathVariable subjectIdentifier : Long, @PathVariable gradeIdentifier : Long) : Grade {
        try {
            return gradeService.removeGradeOfSubjectForStudentIdentifiedBy(subjectIdentifier, gradeIdentifier)
        } catch (exception : RuntimeException){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, exception.message, exception)
        }
    }

    @PostMapping("/{gradeIdentifier}", consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun addPictureToGradeIdentifiedBy(@PathVariable gradeIdentifier: Long, @RequestParam file: MultipartFile): GradeDTO {
        var grade = gradeService.addPicture(gradeIdentifier, file)
        var images = grade.images.map { image -> ImageDTO(image.id!!, image.picture) }
        return GradeDTO(grade.id!!, grade.title, grade.number(), images)
    }

    @DeleteMapping("/{gradeIdentifier}/{pictureId}")
    @ResponseStatus(HttpStatus.OK)
    fun removePictureOfGradeIdentifiedBy(@PathVariable gradeIdentifier: Long, @PathVariable pictureId: Long): GradeDTO {
        var grade = gradeService.removePictureOf(gradeIdentifier, pictureId)
        var images = grade.images.map { image -> ImageDTO(image.id!!, image.picture) }
        return GradeDTO(grade.id!!, grade.title, grade.number(), images)
    }
}
