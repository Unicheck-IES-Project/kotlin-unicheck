package com.unicheck.kotlinunicheckbackend.model

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class EstudianteTest {

    private val USERNAME = "nicolas"
    private val PASSWORD = "demaio"

    @Test
    fun `un estudiante no puede tener nombre de usuario vacio`(){
        val exception = assertThrows(InstantiationException::class.java,
            { Estudiante.identificadoCon(" ", PASSWORD) }
        )

        assertEquals("El nombre de usuario no puede estar en blanco", exception.message)
    }

    @Test
    fun `un estudiante no puede tener una password en blanco`(){
        val exception = assertThrows(InstantiationException::class.java,
            { Estudiante.identificadoCon(USERNAME, " ") }
        )

        assertEquals("La contraseña no puede estar en blanco", exception.message)
    }


    @Test
    fun `cuando un estudiante es creado, no tiene materias registradas`() {
        val estudiante = Estudiante.identificadoCon(USERNAME, PASSWORD)

        assertTrue(estudiante.materiasRegistradas().isEmpty())
    }

    @Test
    fun `un estudiante puede registrar una materia`() {
        val estudiante = Estudiante.identificadoCon(USERNAME, PASSWORD)
        val unaMateria = Materia("Lengua I", "Anual", true, 2022 ,9f)

        estudiante.registrar(unaMateria)

        assertTrue(estudiante.materiasRegistradas().contains(unaMateria))
    }

    @Test
    fun `cuando un estudiante es registrado con una password, es identificado con la password dada`() {
        val estudiante = Estudiante.identificadoCon(USERNAME, PASSWORD)

        assertTrue(estudiante.estaIdentificadoConContraseña(PASSWORD))
    }

    @Test
    fun `cuando un estudiante es registrado con una password, no esta identificado con una password distinta`() {
        val estudiante = Estudiante.identificadoCon(USERNAME, PASSWORD)

        assertFalse(estudiante.estaIdentificadoConContraseña("Otra contraseña"))
    }

}