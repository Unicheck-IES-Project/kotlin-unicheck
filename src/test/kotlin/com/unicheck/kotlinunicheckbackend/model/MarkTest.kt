package com.unicheck.kotlinunicheckbackend.model

import org.assertj.core.api.Assertions
import org.junit.Test

class MarkTest {

    @Test
    fun `a mark cannot be created with blank title`() {
        Assertions
            .assertThatThrownBy { Mark.withTitle(" ", 9f) }
            .isInstanceOf(InstantiationException::class.java)
            .hasMessage("El titulo de calificación no puede estar en blanco.")
    }

    @Test
    fun `a mark number must be greater than zero`() {
        Assertions
            .assertThatThrownBy { Mark.withTitle("TP 1", 0f) }
            .isInstanceOf(InstantiationException::class.java)
            .hasMessage("La nota numérica debe ser mayor a 0 y menor a 11.")
    }

    @Test
    fun `a mark number must be less or equals than ten`() {
        Assertions
            .assertThatThrownBy { Mark.withTitle("TP 1", 11f) }
            .isInstanceOf(InstantiationException::class.java)
            .hasMessage("La nota numérica debe ser mayor a 0 y menor a 11.")
    }

    @Test
    fun `a mark number is created correctly`() {
        val mark = Mark.withTitle("TP 1", 10f)

        Assertions.assertThat(mark.title()).isEqualTo("TP 1")
        Assertions.assertThat(mark.number()).isEqualTo(10f)
    }

}