package mx.unam.dgtic.proyecto.servicios;

import mx.unam.dgtic.proyecto.dto.PrecioDto;
import mx.unam.dgtic.proyecto.modelo.Precio;
import mx.unam.dgtic.proyecto.repositorios.ArticuloRepository;
import mx.unam.dgtic.proyecto.repositorios.PrecioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrecioDtoServiceImpl implements PrecioDtoService {
    @Autowired
    private PrecioRepository precioRepository;

    @Autowired
    private ArticuloRepository articuloRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PrecioDto> obtenerPrecios() {
        return precioRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PrecioDto obtener(Integer id) {
        Precio precio = precioRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("No se encontró precio con id " + id)
                );
        return convertToDto(precio);
    }

    @Override
    public PrecioDto guardar(PrecioDto precioDto) {
        Precio precio = convertToEntity(precioDto);
        Precio nuevoPrecio = precioRepository.save(precio);
        return convertToDto(nuevoPrecio);
    }

    @Override
    public PrecioDto actualizar(Integer id, PrecioDto precioDto) {
        Precio precioExistente = precioRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("No se encontró precio con id " + id)
                );
        updatePrecioFromDto(precioDto, precioExistente);
        return convertToDto(precioRepository.save(precioExistente));
    }

    @Override
    public PrecioDto eliminar(Integer id) {
        Precio precio = precioRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("No se encontró precio con id " + id)
                );
        precioRepository.deleteById(id);
        return convertToDto(precio);
    }

    private PrecioDto convertToDto(Precio precio) {
        return modelMapper.map(precio, PrecioDto.class);
    }

    private Precio convertToEntity(PrecioDto precioDto) {
        return modelMapper.map(precioDto, Precio.class);
    }

    private void updatePrecioFromDto(PrecioDto precioDto, Precio precio) {
        precio.setId(precioDto.getId());
        precio.setPrecio(precioDto.getPrecio());
        precio.setFechaRegistro(precioDto.getFechaRegistro());
        precio.setEstatusActivo(precioDto.getEstatusActivo());
        precio.setArticulo(
                articuloRepository.findById(precioDto.getArticuloId())
                        .orElseThrow(
                                () -> new RuntimeException("No se encontró articulo con id " + precioDto.getArticuloId())
                        )
        );
    }
}