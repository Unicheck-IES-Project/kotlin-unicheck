package com.unicheck.kotlinunicheckbackend.service

import com.unicheck.kotlinunicheckbackend.model.Doc
import com.unicheck.kotlinunicheckbackend.repository.DocRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.util.*


@Service
class DocStorageService {
    @Autowired
    lateinit var docRepository: DocRepository
    fun saveFile(file: MultipartFile): Doc? {
        val docname = file.originalFilename
        try {
            val doc = Doc(docname!!, file.contentType!!, file.bytes)
            return docRepository.save(doc)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    fun getFile(fileId: Int): Optional<Doc> {
        return docRepository.findById(fileId.toLong())
    }
    fun getFiles() : List<Doc>{
        return docRepository.findAll()
    }
}