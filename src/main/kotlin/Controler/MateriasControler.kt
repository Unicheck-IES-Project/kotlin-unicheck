package Controler

import LogicaDeNegocio.Materia
import Service.MateriasService


class MateriasControler(var materiasService: MateriasService) {

    fun agregarUnaMateria (materia: Materia){
        //No viene una materia, viene un request HTTP, futuro cambio
        var materias = materiasService.agregarMateria(materia)
        return materias

    }

}