package mx.unam.dgtic.proyecto.servicios;

import mx.unam.dgtic.proyecto.dto.PrecioDto;

import java.util.List;

public interface PrecioDtoService {
    List<PrecioDto> obtenerPrecios();

    PrecioDto obtener(Integer id);

    PrecioDto guardar(PrecioDto precioDto);

    PrecioDto actualizar(Integer id, PrecioDto precioDto);

    PrecioDto eliminar(Integer id);
}