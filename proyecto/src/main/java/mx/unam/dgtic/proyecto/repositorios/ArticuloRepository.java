package mx.unam.dgtic.proyecto.repositorios;

import mx.unam.dgtic.proyecto.modelo.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Integer> {
    public List<Articulo> findByDescripcionContaining(String descripcion);
}