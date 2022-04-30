package com.unicheck.kotlinunicheckbackend.service


/*@RunWith(MockitoJUnitRunner::class)
class MateriasServiceTest {

    lateinit var materia: Materia

    @Mock
    lateinit var materiaRepository : MateriasRepository

    @InjectMocks
    lateinit var materiasService : MateriasService

    private fun <T> any(type: Class<T>): T = Mockito.any<T>(type)

    @Test
    fun `se pueden listar las materias de un estudiante`() {
        var nombreDeLaMateria = "Elementos De Ingenieria De Software"
        var periodoDeCursada = "Elementos De Ingenieria De Software"
        var nota = 2f
        var cursando = false
        var año = 2022
        materia  = Materia(nombreDeLaMateria,
            periodoDeCursada,
            cursando,
            año,
            nota)

        var listaDeMaterias : List<Materia> = listOf(materia)
        `when`(materiaRepository.findAll()).thenReturn(listaDeMaterias)

        Assertions.assertTrue(  materiasService.listarMaterias().contains(materia)  )
    }

    @Test
    fun alAñadirUnaMateriaEstaTieneLosDatosCorrespondientesTest() {
        var nombreDeLaMateria = "Elementos De Ingenieria De Software"
        var periodoDeCursada = "Elementos De Ingenieria De Software"
        var nota = 2f
        var cursando = false
        var año = 2022
        var idDeEstudiante =
        materia  = PeticionMateria(nombreDeLaMateria,
            periodoDeCursada,
            cursando,
            año,
            nota,
            idDeEstudiante)

        `when`(materiaRepository.save( any( Materia::class.java )) ).thenReturn(materia)

        var materiaGuardada: Materia = materiasService.agregarMateria(materia)

        Assertions.assertEquals( materiaGuardada.nombre, nombreDeLaMateria)
        Assertions.assertEquals( materiaGuardada.periodoDeCursada, periodoDeCursada)
        Assertions.assertEquals( materiaGuardada.nota, nota)
        Assertions.assertEquals( materiaGuardada.cursando, cursando)
        Assertions.assertEquals( materiaGuardada.añoDeCursada, año)
    }

}*/