package LogicaDeNegocioTest

import LogicaDeNegocio.Materia
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.assertThrows


class MateriaTest {

    lateinit var materia: Materia

    @Test
    fun constructorTest() {

        var nombreDeLaMateria = "Elementos De Ingenieria De Software"
        var periodoDeCursada = "Elementos De Ingenieria De Software"
        var nota = 7f
        var cursando = false

         materia  = Materia(nombreDeLaMateria,
                            periodoDeCursada,
                            nota,
                            cursando)

        Assertions.assertEquals( materia.nombre, nombreDeLaMateria)
        Assertions.assertEquals( materia.periodoDeCursada, periodoDeCursada)
        Assertions.assertEquals( materia.nota, nota)
        Assertions.assertEquals( materia.cursando, cursando)
    }

    @Test
    fun unaMateriaNoPuedeTenerUnaNotaMenorAUnoTest(){
        var nombreDeLaMateria = "Elementos De Ingenieria De Software"
        var periodoDeCursada = "Elementos De Ingenieria De Software"
        var notaMenorAUno = 0f
        var cursando = false

        val exception = assertThrows<java.lang.RuntimeException> {
            materia  = Materia(nombreDeLaMateria,
            periodoDeCursada,
            notaMenorAUno,
            cursando)
        }

        Assertions.assertEquals("La nota debe estar comprendida entre los valores 1 y 10", exception.message)

    }

    @Test
    fun unaMateriaNoPuedeTenerUnaNotaMayorADiezTest(){
        var nombreDeLaMateria = "Elementos De Ingenieria De Software"
        var periodoDeCursada = "Elementos De Ingenieria De Software"
        var notaMayorADiez = 11f
        var cursando = false

        val exception = assertThrows<java.lang.RuntimeException> {
            materia  = Materia(nombreDeLaMateria,
                periodoDeCursada,
                notaMayorADiez,
                cursando)
        }

        Assertions.assertEquals("La nota debe estar comprendida entre los valores 1 y 10", exception.message)

    }

    @Test
    fun unaMateriaNoPuedeTenerUnNombreVacioTest(){
        var nombreDeLaMateria = ""
        var periodoDeCursada = "Elementos De Ingenieria De Software"
        var nota = 7f
        var cursando = false

        val exception = assertThrows<java.lang.RuntimeException> {
            materia  = Materia(nombreDeLaMateria,
                periodoDeCursada,
                nota,
                cursando)
        }

        Assertions.assertEquals("El nombre no puede estar vacio", exception.message)


    }

}