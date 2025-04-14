package mx.unam.dgtic.proyecto.controladores;

import mx.unam.dgtic.proyecto.dto.PrecioDto;
import mx.unam.dgtic.proyecto.servicios.PrecioDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/precios")
public class PrecioDtoRestController {
    @Autowired
    private PrecioDtoService precioDtoService;

    @GetMapping("/")
    public ResponseEntity<List<PrecioDto>> getAll() {
        return ResponseEntity.ok(
                precioDtoService.obtenerPrecios()
                        .stream()
                        .collect(Collectors.toList())
        );
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PrecioDto> getPrecio(@PathVariable Integer id) {
        return ResponseEntity.ok(precioDtoService.obtener(id));
    }

    @PostMapping("/")
    public ResponseEntity<PrecioDto> createPrecio(@RequestBody PrecioDto precioDto) {
        return ResponseEntity.ok(precioDtoService.guardar(precioDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrecioDto> updatePrecio(
            @PathVariable Integer id, @RequestBody PrecioDto precioDto) {
        return ResponseEntity.ok(precioDtoService.actualizar(id, precioDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PrecioDto> deletePrecio(@PathVariable Integer id) {
        return ResponseEntity.ok(precioDtoService.eliminar(id));
    }
}