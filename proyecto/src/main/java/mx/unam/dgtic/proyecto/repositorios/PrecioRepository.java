package mx.unam.dgtic.proyecto.repositorios;

import mx.unam.dgtic.proyecto.modelo.Precio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrecioRepository extends JpaRepository<Precio,Integer> {
    List<Precio> searchPrecioActivoParaArticulo(Integer idArticulo);
}