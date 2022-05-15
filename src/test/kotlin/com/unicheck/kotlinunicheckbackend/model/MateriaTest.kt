package com.unicheck.kotlinunicheckbackend.model

import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows


class MateriaTest {

    lateinit var materia: Materia
    lateinit var estudiante: Estudiante

    @Before
    fun setup() {
        estudiante = Estudiante.identificadoCon("Julian", "trejo83")
    }

    @Test
    fun constructorTest() {

        val nombreDeLaMateria = "Elementos De Ingenieria De Software"
        val periodoDeCursada = "Elementos De Ingenieria De Software"
        val nota = 7f
        val cursando = false
        val año = 2022

        materia  = Materia(nombreDeLaMateria,
            periodoDeCursada,
            cursando,
            año,
            nota,
            estudiante)

        Assertions.assertEquals( materia.nombre, nombreDeLaMateria)
        Assertions.assertEquals( materia.periodoDeCursada, periodoDeCursada)
        Assertions.assertEquals( materia.notas.first().number(), nota)
        Assertions.assertEquals( materia.notas.first().title(), "Nota final")
        Assertions.assertEquals( materia.cursando, cursando)
        Assertions.assertEquals( materia.añoDeCursada, año)
    }
    @Test
    fun unaMateriaNoPuedeTenerUnaNotaMenorAUnoTest(){
        val nombreDeLaMateria = "Elementos De Ingenieria De Software"
        val periodoDeCursada = "Elementos De Ingenieria De Software"
        val notaMenorAUno = 0f
        val cursando = false
        val año = 2022

        val exception = assertThrows<java.lang.InstantiationException> {
            materia  = Materia(nombreDeLaMateria,
                periodoDeCursada,
                cursando,
                año,
                notaMenorAUno,
                estudiante = estudiante)
        }

        Assertions.assertEquals("La nota numérica debe ser mayor a 0 y menor a 11.", exception.message)

    }

    @Test
    fun unaMateriaNoPuedeTenerUnaNotaMayorADiezTest(){
        val nombreDeLaMateria = "Elementos De Ingenieria De Software"
        val periodoDeCursada = "Elementos De Ingenieria De Software"
        val notaMayorADiez = 11f
        val cursando = false
        val año = 2022

        val exception = assertThrows<java.lang.InstantiationException> {
            materia  = Materia(nombreDeLaMateria,
                periodoDeCursada,
                cursando,
                año,
                notaMayorADiez,
                estudiante)
        }

        Assertions.assertEquals("La nota numérica debe ser mayor a 0 y menor a 11.", exception.message)

    }
    @Test
    fun unaMateriaNoPuedeTenerUnNombreVacioTest(){
        val nombreDeLaMateria = ""
        val periodoDeCursada = "Elementos De Ingenieria De Software"
        val nota = 7f
        val cursando = false
        val año = 2022

        val exception = assertThrows<java.lang.RuntimeException> {
            materia  = Materia(nombreDeLaMateria,
                periodoDeCursada,
                cursando,
                año,
                nota,
                estudiante)
        }

        Assertions.assertEquals("El nombre no puede estar vacio", exception.message)

    }

    @Test
    fun unaMateriaPuedeNoTenerUnaNotaTest(){
        val nombreDeLaMateria = "Elementos De Ingenieria De Software"
        val periodoDeCursada = "Elementos De Ingenieria De Software"
        val cursando = false
        val año = 2022

        val materia  = Materia(nombreDeLaMateria,
                periodoDeCursada,
                cursando,
                año,
                estudiante = estudiante)


        Assertions.assertEquals( materia.nombre, nombreDeLaMateria)
        Assertions.assertEquals( materia.periodoDeCursada, periodoDeCursada)
        Assertions.assertTrue( materia.notas.isEmpty())
        Assertions.assertEquals( materia.cursando, cursando)
        Assertions.assertEquals( materia.añoDeCursada, año)

    }

    @Test
    fun materiaUpdateTest() {

        val nombreDeLaMateria = "Elementos De Ingenieria De Software"
        val periodoDeCursada = "Elementos De Ingenieria De Software"
        val nota = 7f
        val cursando = false
        val año = 2022

        val nuevoNombreDeLaMateria = "Elementos De Ingenieria De Software2"
        val nuevoPeriodoDeCursada = "Anual"
        val nuevaNota = 7f
        val nuevoCursando = false
        val nuevoAño = 2010

        materia  = Materia(nombreDeLaMateria,
            periodoDeCursada,
            cursando,
            año,
            nota,
            estudiante)

        materia.update(nuevoNombreDeLaMateria, nuevoPeriodoDeCursada, nuevoCursando, nuevoAño, nuevaNota)

        Assertions.assertEquals( materia.nombre, nuevoNombreDeLaMateria)
        Assertions.assertEquals( materia.periodoDeCursada, nuevoPeriodoDeCursada)
        Assertions.assertEquals( materia.notas.first().number(), nuevaNota)
        Assertions.assertEquals( materia.notas.first().title(), "Nota final")
        Assertions.assertEquals( materia.cursando, nuevoCursando)
        Assertions.assertEquals( materia.añoDeCursada, nuevoAño)
    }

}