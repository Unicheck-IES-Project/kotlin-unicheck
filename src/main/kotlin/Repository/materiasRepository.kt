package Repository

import LogicaDeNegocio.Materia
import org.springframework.data.jpa.repository.JpaRepository

interface materiasRepository : JpaRepository<Materia, Long>  {}