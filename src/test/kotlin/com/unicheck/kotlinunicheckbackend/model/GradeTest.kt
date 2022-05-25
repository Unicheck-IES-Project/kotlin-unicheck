package com.unicheck.kotlinunicheckbackend.model

import org.assertj.core.api.Assertions
import org.junit.Test

class GradeTest {

    @Test
    fun `a mark cannot be created with blank title`() {
        Assertions
            .assertThatThrownBy { Grade.withTitle(" ", 9f) }
            .isInstanceOf(RuntimeException::class.java)
            .hasMessage("El titulo de calificación no puede estar en blanco.")
    }

    @Test
    fun `a mark number must be greater than zero`() {
        Assertions
            .assertThatThrownBy { Grade.withTitle("TP 1", 0f) }
            .isInstanceOf(RuntimeException::class.java)
            .hasMessage("La nota numérica debe ser mayor a 0 y menor a 11.")
    }

    @Test
    fun `a mark number must be less or equals than ten`() {
        Assertions
            .assertThatThrownBy { Grade.withTitle("TP 1", 11f) }
            .isInstanceOf(RuntimeException::class.java)
            .hasMessage("La nota numérica debe ser mayor a 0 y menor a 11.")
    }

    @Test
    fun `a mark number is created correctly`() {
        val grade = Grade.withTitle("TP 1", 10f)

        Assertions.assertThat(grade.title()).isEqualTo("TP 1")
        Assertions.assertThat(grade.number()).isEqualTo(10f)
    }

}