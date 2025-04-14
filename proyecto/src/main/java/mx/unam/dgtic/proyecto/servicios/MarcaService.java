package mx.unam.dgtic.proyecto.servicios;

import mx.unam.dgtic.proyecto.modelo.Marca;

import java.util.List;

public interface MarcaService {
    Marca crear(Marca marca);

    List<Marca> obtener();

    Marca actualizar(Integer id, Marca marca);

    Marca eliminar(Integer id);
}