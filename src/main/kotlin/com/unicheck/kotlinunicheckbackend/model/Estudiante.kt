package com.unicheck.kotlinunicheckbackend.model

import java.util.*
import javax.persistence.*

@Entity
class Estudiante {

    companion object {
        fun identificadoCon(unNombreDeUsuario : String, unaContraseña : String) : Estudiante {
            StudentCreationValidator(unNombreDeUsuario, unaContraseña).validate()
            return Estudiante(unNombreDeUsuario, unaContraseña)
        }
    }

    private val nombreDeUsuario : String
    private val contraseña : String

    @OneToMany(mappedBy="estudiante", cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
    private val materias : MutableList<Materia>
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    var id: Long? = null

    private constructor(unNombreDeUsuario : String, unaContraseña : String){
        nombreDeUsuario = unNombreDeUsuario
        contraseña = unaContraseña
        materias = mutableListOf()
    }

    fun materiasRegistradas() : Collection<Materia> {
        return Collections.unmodifiableList(materias)
    }

    fun estaIdentificadoConContraseña(unaContraseñaAComparar: String): Boolean {
        return contraseña.equals(unaContraseñaAComparar)
    }

    fun getNombre():String{
        return this.nombreDeUsuario
    }
    fun getId():Long{
        return this.id!!
    }

    fun registrarMateriaLlamada(
        nombre: String,
        periodoDeCursada: String,
        cursando: Boolean,
        añoDeCursada: Int,
        nota: Float?
    ): Materia {
        val materia = Materia(nombre, periodoDeCursada, cursando, añoDeCursada, nota, this)
        materias.add(materia)
        return materia
    }

    fun delete(subjectToDelete: Materia?) {
        if (materias.contains(subjectToDelete)) {
            materias.remove(subjectToDelete)
        } else {
            throw RuntimeException("Materia no registrada por estudiante ${nombreDeUsuario}.")
        }
    }

}