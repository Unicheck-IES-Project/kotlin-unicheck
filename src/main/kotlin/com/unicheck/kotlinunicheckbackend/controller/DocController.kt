package com.unicheck.kotlinunicheckbackend.controller

import com.unicheck.kotlinunicheckbackend.exceptions.StudentNotFoundException
import com.unicheck.kotlinunicheckbackend.exceptions.SubjectNotFoundException
import com.unicheck.kotlinunicheckbackend.model.Doc
import com.unicheck.kotlinunicheckbackend.service.DocStorageService
import com.unicheck.kotlinunicheckbackend.service.EstudianteService
import com.unicheck.kotlinunicheckbackend.service.MateriasService
import com.unicheck.kotlinunicheckbackend.service.dtos.SubjectCreationRequest
import com.unicheck.kotlinunicheckbackend.service.dtos.SubjectDTO
import com.unicheck.kotlinunicheckbackend.service.dtos.SubjectModificationRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ByteArrayResource
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.server.ResponseStatusException


@RestController
@RequestMapping("/api/v1/{subjectIdentifier}/{gradeIdentifier}/galery")
@CrossOrigin
class DocController {
    @Autowired
    private lateinit var docStorageService: DocStorageService

    @GetMapping
    fun get(@PathVariable subjectIdentifier : Long, @PathVariable gradeIdentifier : Long) : List<Doc>{
        return docStorageService.getFiles()
    }
/*
    /////POR FILTRAR
    @PostMapping("/uploadFiles")
    fun uploadMultipleFiles(@RequestParam("files") files: Array<MultipartFile?>): String {
        for (file in files) {
            docStorageService.saveFile(file)
        }
        return "redirect:/"
    }

    @GetMapping("/downloadFile/{fileId}")
    fun downloadFile(@PathVariable fileId: Int?): ResponseEntity<ByteArrayResource> {
        val doc: Doc = docStorageService.getFile(fileId).get()
        return ResponseEntity.ok()
            .contentType(MediaType.parseMediaType(doc.getDocType()))
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment:filename=\"" + doc.getDocName() + "\"")
            .body(ByteArrayResource(doc.getData()))
    }
*/
}

/*
class MateriasController {

    @Autowired
    private lateinit var materiasService: MateriasService

    @Autowired
    private lateinit var estudianteService: EstudianteService

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun registrarMateria (@PathVariable studentIdentifier : Long, @RequestBody request : SubjectCreationRequest) : SubjectDTO {
        try {
            val addedSubject = materiasService.addSubjectToStudentIdentifiedBy(studentIdentifier, request)
            return SubjectDTO(addedSubject)
        } catch(e: StudentNotFoundException){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,e.message!!,e)
        } catch(e: RuntimeException){
            throw ResponseStatusException(HttpStatus.BAD_REQUEST,e.message!!,e)
        }
    }

    @GetMapping
    fun materiasParaEstudianteIdentificadoCon(@PathVariable studentIdentifier : Long) : Collection<SubjectDTO> {
        return materiasService.subjectsOfStudentIdentifiedBy(studentIdentifier).map { subject -> SubjectDTO(subject) }
    }

    @PutMapping("/{subjectIdentifier}")
    @ResponseStatus(HttpStatus.OK)
    fun updateSubjectFor(@PathVariable studentIdentifier: Long, @RequestBody request : SubjectModificationRequest,
                         @PathVariable subjectIdentifier : Long) : SubjectDTO {
        try {
            return SubjectDTO(materiasService.updateSubjectIdentifiedBy(request, subjectIdentifier))
        } catch (exception : SubjectNotFoundException){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, exception.message, exception)
        } catch (exception : RuntimeException){
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, exception.message, exception)
        }
    }

    @DeleteMapping("/{subjectIdentifier}")
    @ResponseStatus(HttpStatus.OK)
    fun borrarMateria(@PathVariable studentIdentifier: Long, @PathVariable subjectIdentifier : Long) : SubjectDTO {
        try {
            return SubjectDTO(materiasService.deleteSubjectForStudentIdentifiedBy(studentIdentifier, subjectIdentifier))
        } catch (exception : RuntimeException){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, exception.message, exception)
        }
    }
*/
