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

        var nombreDeLaMateria = "Elementos De Ingenieria De Software"
        var periodoDeCursada = "Elementos De Ingenieria De Software"
        var nota = 7f
        var cursando = false
        var año = 2022

        materia  = Materia(nombreDeLaMateria,
            periodoDeCursada,
            cursando,
            año,
            nota,
            estudiante)

        Assertions.assertEquals( materia.nombre, nombreDeLaMateria)
        Assertions.assertEquals( materia.periodoDeCursada, periodoDeCursada)
        Assertions.assertEquals( materia.nota, nota)
        Assertions.assertEquals( materia.cursando, cursando)
        Assertions.assertEquals( materia.añoDeCursada, año)
    }
    @Test
    fun unaMateriaNoPuedeTenerUnaNotaMenorAUnoTest(){
        var nombreDeLaMateria = "Elementos De Ingenieria De Software"
        var periodoDeCursada = "Elementos De Ingenieria De Software"
        var notaMenorAUno = 0f
        var cursando = false
        var año = 2022

        val exception = assertThrows<java.lang.RuntimeException> {
            materia  = Materia(nombreDeLaMateria,
                periodoDeCursada,
                cursando,
                año,
                notaMenorAUno,
                estudiante = estudiante)
        }

        Assertions.assertEquals("La nota debe estar comprendida entre los valores 1 y 10", exception.message)

    }

    @Test
    fun unaMateriaNoPuedeTenerUnaNotaMayorADiezTest(){
        var nombreDeLaMateria = "Elementos De Ingenieria De Software"
        var periodoDeCursada = "Elementos De Ingenieria De Software"
        var notaMayorADiez = 11f
        var cursando = false
        var año = 2022

        val exception = assertThrows<java.lang.RuntimeException> {
            materia  = Materia(nombreDeLaMateria,
                periodoDeCursada,
                cursando,
                año,
                notaMayorADiez,
                estudiante)
        }

        Assertions.assertEquals("La nota debe estar comprendida entre los valores 1 y 10", exception.message)

    }
    @Test
    fun unaMateriaNoPuedeTenerUnNombreVacioTest(){
        var nombreDeLaMateria = ""
        var periodoDeCursada = "Elementos De Ingenieria De Software"
        var nota = 7f
        var cursando = false
        var año = 2022

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
        var nombreDeLaMateria = "Elementos De Ingenieria De Software"
        var periodoDeCursada = "Elementos De Ingenieria De Software"
        var cursando = false
        var año = 2022

        var materia  = Materia(nombreDeLaMateria,
                periodoDeCursada,
                cursando,
                año,
                estudiante = estudiante)


        Assertions.assertEquals( materia.nombre, nombreDeLaMateria)
        Assertions.assertEquals( materia.periodoDeCursada, periodoDeCursada)
        Assertions.assertEquals( materia.nota, null)
        Assertions.assertEquals( materia.cursando, cursando)
        Assertions.assertEquals( materia.añoDeCursada, año)

    }

}