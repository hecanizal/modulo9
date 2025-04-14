package mx.unam.dgtic.proyecto.repositorios;

import mx.unam.dgtic.proyecto.modelo.Familia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamiliaRepository extends JpaRepository<Familia, String> {
}