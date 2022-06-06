package com.unicheck.kotlinunicheckbackend.repository

import com.unicheck.kotlinunicheckbackend.model.Grade
import com.unicheck.kotlinunicheckbackend.model.Image
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ImageRepository : JpaRepository<Image, Long> {
}