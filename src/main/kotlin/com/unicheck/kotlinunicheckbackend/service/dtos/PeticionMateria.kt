package com.unicheck.kotlinunicheckbackend.service.dtos

import com.unicheck.kotlinunicheckbackend.model.Materia

class PeticionMateria(var nombre:String,
                      var periodoDeCursada:String,
                      var cursando:Boolean,
                      var añoDeCursada: Int,
                      var nota:Float?,
                      var idUsuario : Long) {}