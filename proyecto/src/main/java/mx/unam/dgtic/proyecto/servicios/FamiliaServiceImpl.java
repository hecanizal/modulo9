package mx.unam.dgtic.proyecto.servicios;

import mx.unam.dgtic.proyecto.modelo.Familia;
import mx.unam.dgtic.proyecto.repositorios.FamiliaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamiliaServiceImpl implements FamiliaService {
    @Autowired
    private FamiliaRepository familiaRepository;

    @Override
    public Familia crear(Familia familia) {
        return familiaRepository.save(familia);
    }

    @Override
    public List<Familia> obtener() {
        return familiaRepository.findAll();
    }

    @Override
    public Familia actualizar(String id, Familia familia) {
        Familia familiaExistente = familiaRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("No se encontró familia con id " + id)
                );
        familiaExistente.setId(id);
        familiaExistente.setNombre(familia.getNombre());
        return familiaRepository.save(familiaExistente);
    }

    @Override
    public Familia eliminar(String id) {
        Familia familiaExistente = familiaRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("No se encontró familia con id " + id)
                );
        familiaRepository.delete(familiaExistente);
        return familiaExistente;
    }
}