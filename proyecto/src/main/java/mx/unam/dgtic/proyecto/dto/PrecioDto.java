package mx.unam.dgtic.proyecto.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PrecioDto {
    private Integer id;
    private Double precio;
    private LocalDate fechaRegistro;
    private Boolean estatusActivo;
    private Integer articuloId;
}