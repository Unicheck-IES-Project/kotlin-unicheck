package com.unicheck.kotlinunicheckbackend.repository

import com.unicheck.kotlinunicheckbackend.model.Doc
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DocRepository : JpaRepository<Doc, Long> {}