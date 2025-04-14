package mx.unam.dgtic.proyecto.servicios;

import mx.unam.dgtic.proyecto.modelo.Precio;

import java.util.List;

public interface PrecioService {
    List<Precio> obtenerPrecios();
    Precio obtener(Integer id);
    Precio guardar(Precio precio);
    Precio actualizar(Integer id, Precio precio);
    Precio eliminar(Integer id);
}