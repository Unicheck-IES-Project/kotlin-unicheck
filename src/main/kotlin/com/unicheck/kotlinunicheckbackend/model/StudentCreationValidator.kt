package com.unicheck.kotlinunicheckbackend.model

class StudentCreationValidator(
    private val anUsername: String,
    private val aPassword: String) {

    fun validate() {
        validateNotBlankOrElseWarnWith("La contraseña no puede estar en blanco", aPassword)
        validateNotBlankOrElseWarnWith("El nombre de usuario no puede estar en blanco", anUsername)
    }

    private fun validateNotBlankOrElseWarnWith(anErrorMessage : String, textToValidate : String){
        if (textToValidate.isBlank()) throw InstantiationException(anErrorMessage)
    }
}