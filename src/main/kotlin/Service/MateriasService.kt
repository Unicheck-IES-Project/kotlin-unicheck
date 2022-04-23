package Service

import LogicaDeNegocio.Materia
import Repository.materiasRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MateriasService(@Autowired var materiasRepository: materiasRepository){

     fun agregarMateria(materia: Materia): Materia{
        materiasRepository.save(materia)
        return materia
    }

    fun listarMaterias(): List<Materia>{
        return materiasRepository.findAll()
    }
}