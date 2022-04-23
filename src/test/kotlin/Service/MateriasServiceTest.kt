package Service

import com.unicheck.kotlinunicheckbackend.LogicaDeNegocio.Materia
import com.unicheck.kotlinunicheckbackend.Repository.MateriasRepository
import com.unicheck.kotlinunicheckbackend.Service.MateriasService
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class MateriasServiceTest {

    lateinit var materia: Materia

    @Mock
    lateinit var materiaRepository : MateriasRepository

    @InjectMocks
    lateinit var materiasService : MateriasService

    private fun <T> any(type: Class<T>): T = Mockito.any<T>(type)

    @Test
    fun cuandoSeAgregaUnaMateriaEstaSeEncuentraDentroDelListadoDeMateriasTest() {
        var nombreDeLaMateria = "Elementos De Ingenieria De Software"
        var periodoDeCursada = "Elementos De Ingenieria De Software"
        var nota = 2f
        var cursando = false
        materia  = Materia(nombreDeLaMateria,
            periodoDeCursada,
            nota,
            cursando)

        `when`(materiaRepository.save( any( Materia::class.java )) ).thenReturn(materia)

        var listaDeMaterias : List<Materia> = listOf(materia)
        `when`(materiaRepository.findAll()).thenReturn(listaDeMaterias)

        Assertions.assertTrue(  materiasService.listarMaterias().contains(materia)  )
    }

}