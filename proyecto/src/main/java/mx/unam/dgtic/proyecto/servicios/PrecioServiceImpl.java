package mx.unam.dgtic.proyecto.servicios;

import mx.unam.dgtic.proyecto.modelo.Precio;
import mx.unam.dgtic.proyecto.repositorios.PrecioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrecioServiceImpl implements PrecioService {
    @Autowired
    private PrecioRepository precioRepository;

    @Override
    public List<Precio> obtenerPrecios() {
        return precioRepository.findAll();
    }

    @Override
    public Precio obtener(Integer id) {
        return precioRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("No se encontró precio con id " + id)
                );
    }

    @Override
    public Precio guardar(Precio precio) {
        return precioRepository.save(precio);
    }

    @Override
    public Precio actualizar(Integer id, Precio precio) {
        Precio precioExistente = precioRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("No se encontró precio con id " + id)
                );
        precioExistente.setArticulo(precio.getArticulo());
        precioExistente.setPrecio(precio.getPrecio());
        precioExistente.setEstatusActivo(precio.getEstatusActivo());
        precioExistente.setFechaRegistro(precio.getFechaRegistro());
        return precioRepository.save(precioExistente);
    }

    @Override
    public Precio eliminar(Integer id) {
        Precio precioExistente = precioRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("No se encontró precio con id " + id)
                );
        precioRepository.deleteById(id);
        return precioExistente;
    }
}