package mx.unam.dgtic.proyecto.servicios;

import mx.unam.dgtic.proyecto.modelo.Articulo;

import java.util.List;

public interface ArticuloService {
    Articulo crear(Articulo articulo);

    List<Articulo> obtener();

    Articulo obtener(Integer idArticulo);

    Articulo actualizar(Integer id, Articulo articulo);

    Articulo eliminar(Integer id);

    List<Articulo> buscarPorDescripcion(String descripcion);

}