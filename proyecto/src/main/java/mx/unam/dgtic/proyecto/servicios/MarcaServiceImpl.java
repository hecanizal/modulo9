package mx.unam.dgtic.proyecto.servicios;

import mx.unam.dgtic.proyecto.modelo.Marca;
import mx.unam.dgtic.proyecto.repositorios.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaServiceImpl implements MarcaService {
    @Autowired
    private MarcaRepository marcaRepository;

    @Override
    public Marca crear(Marca marca) {
        return marcaRepository.save(marca);
    }

    @Override
    public List<Marca> obtener() {
        return marcaRepository.findAll();
    }

    @Override
    public Marca actualizar(Integer id, Marca marca) {
        Marca marcaExistente = marcaRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("No se encontró marca con id " + id)
                );
        marcaExistente.setId(id);
        marcaExistente.setNombre(marca.getNombre());
        return marcaRepository.save(marcaExistente);
    }

    @Override
    public Marca eliminar(Integer id) {
        Marca marcaExistente = marcaRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("No se encontró marca con id " + id)
                );
        marcaRepository.delete(marcaExistente);
        return marcaExistente;
    }
}