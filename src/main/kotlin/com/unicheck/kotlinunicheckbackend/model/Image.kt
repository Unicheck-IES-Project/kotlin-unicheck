package com.unicheck.kotlinunicheckbackend.model

import javax.persistence.*


@Entity
data class Image(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,

    @Lob
    var picture: ByteArray,

    @ManyToOne(fetch = FetchType.LAZY)
    var grade: Grade
)