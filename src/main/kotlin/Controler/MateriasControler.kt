package Controler

import LogicaDeNegocio.Materia
import Service.MateriasService


class MateriasControler(var materiasService: MateriasService) {

    fun agregarUnaMateria (materia: Materia){

        var materias = materiasService.agregarMateria(materia)
        return materias

    }

}