package mx.unam.dgtic.proyecto.repositorios;

import mx.unam.dgtic.proyecto.modelo.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca,Integer> {
}