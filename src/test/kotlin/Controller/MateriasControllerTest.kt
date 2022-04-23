package Controller

import LogicaDeNegocio.Materia
import Service.MateriasService
import org.junit.Test
import org.mockito.Mockito.`when`
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import java.util.Collections.emptyList
import org.hamcrest.Matchers.containsString
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status



@WebMvcTest(MateriasController::class)
class MateriasControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var service: MateriasService

    @Test
    fun testListarMaterias() {
        var matematica: Materia = Materia("Matematica", "Anual", 9f, true)
        var materias: MutableList<Materia> = emptyList()
        materias.add(matematica)

        `when`(service.listarMaterias()).thenReturn(materias)
        mockMvc!!.perform(get("/api/v1/subjects")).andDo(print()).andExpect(status().isOk())
            .andExpect(content().string(containsString("Hello, Mock")))
    }
}