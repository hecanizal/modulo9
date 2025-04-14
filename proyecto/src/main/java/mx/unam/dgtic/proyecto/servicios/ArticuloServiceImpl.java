package mx.unam.dgtic.proyecto.servicios;

import mx.unam.dgtic.proyecto.modelo.Articulo;
import mx.unam.dgtic.proyecto.repositorios.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloServiceImpl implements ArticuloService {
    @Autowired
    private ArticuloRepository articuloRepository;

    @Override
    public Articulo crear(Articulo articulo) {
        return articuloRepository.save(articulo);
    }

    @Override
    public List<Articulo> obtener() {
        return articuloRepository.findAll();
    }

    @Override
    public Articulo obtener(Integer idArticulo) {
        return articuloRepository.findById(idArticulo).orElse(null);
    }

    @Override
    public Articulo actualizar(Integer id, Articulo articulo) {
        Articulo articuloExistente = articuloRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("No se encontró articulo con id " + id)
                );
        articuloExistente.setId(id);
        articuloExistente.setCodigo(articulo.getCodigo());
        articuloExistente.setClave(articulo.getClave());
        articuloExistente.setDescripcion(articulo.getDescripcion());
        articuloExistente.setUnidad(articulo.getUnidad());
        articuloExistente.setExistencia(articulo.getExistencia());
        articuloExistente.setCodigoBarras(articulo.getCodigoBarras());
        articuloExistente.setMarca(articulo.getMarca());
        articuloExistente.setFamilia(articulo.getFamilia());
        return articuloRepository.save(articuloExistente);
    }

    @Override
    public Articulo eliminar(Integer id) {
        Articulo articuloExistente = articuloRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("No se encontró articulo con id " + id)
                );
        articuloRepository.delete(articuloExistente);
        return articuloExistente;
    }

    @Override
    public List<Articulo> buscarPorDescripcion(String descripcion) {
        return articuloRepository.findByDescripcionContaining(descripcion);
    }
}