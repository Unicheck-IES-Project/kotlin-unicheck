package LogicaDeNegocio

class Materia {

    constructor(nombre:String, calificable:Calificable,nota:Float,cursando:Boolean) {

        if ( nota <= 0f || calificable.getterCalificacion() <= 0f ){
            // Irira un error o exepcion que la nota no puede ser negativa ni tampoco el calificable
        }

    }

}