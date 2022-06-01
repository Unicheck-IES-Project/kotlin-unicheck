package com.unicheck.kotlinunicheckbackend.model

import javax.persistence.*

@Entity
@Table(name = "docs")
class Doc (val docName: String, val docType: String, @Lob val data: ByteArray) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

}