package Service

import LogicaDeNegocio.Materia
import Repository.materiasRepository

class MateriasService(var materiasRepository: materiasRepository) {

    fun agregarMateria(materia: Materia){
        materiasRepository.save(materia)
    }
}