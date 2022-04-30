package com.unicheck.kotlinunicheckbackend.service.dtos

class SubjectCreationRequest(var nombre:String,
                             var periodoDeCursada:String,
                             var cursando:Boolean,
                             var añoDeCursada: Int,
                             var nota:Float?) {}