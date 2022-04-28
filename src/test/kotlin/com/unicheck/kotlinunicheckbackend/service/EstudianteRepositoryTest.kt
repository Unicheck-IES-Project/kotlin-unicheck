package com.unicheck.kotlinunicheckbackend.service

import com.unicheck.kotlinunicheckbackend.model.Estudiante
import com.unicheck.kotlinunicheckbackend.model.Materia
import com.unicheck.kotlinunicheckbackend.repository.EstudianteRepository
import junit.framework.Assert.assertTrue
import org.assertj.core.api.Assertions
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.annotation.Rollback


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class EstudianteRepositoryTest {
    @Autowired
    lateinit  var entityManager: TestEntityManager

    @Autowired
    lateinit var repo: EstudianteRepository

    @Test
    fun testCrearEstudiante() {
        var nombreDeLaMateria = "Elementos De Ingenieria De Software"
        var periodoDeCursada = "Elementos De Ingenieria De Software"
        var nota = 7f
        var cursando = false
        var año = 2022

        val materia  = Materia(nombreDeLaMateria,
            periodoDeCursada,
            nota,
            cursando,
            año)

        val estudiante: Estudiante = Estudiante.identificadoCon("Juan", "Contraseña")
        estudiante.registrar(materia)
        val savedUser: Estudiante = repo.save(estudiante)
        val existUser: Estudiante = entityManager.find(Estudiante::class.java, savedUser.id!!)
        assertTrue(existUser.estaIdentificadoConContraseña("Contraseña"))
    }





}