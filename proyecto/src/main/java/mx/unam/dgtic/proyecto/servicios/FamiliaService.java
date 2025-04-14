package mx.unam.dgtic.proyecto.servicios;

import mx.unam.dgtic.proyecto.modelo.Familia;

import java.util.List;

public interface FamiliaService {
    Familia crear(Familia familia);

    List<Familia> obtener();

    Familia actualizar(String id, Familia familia);

    Familia eliminar(String id);
}