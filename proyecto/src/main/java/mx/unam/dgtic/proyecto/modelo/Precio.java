package mx.unam.dgtic.proyecto.modelo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "precios")
@NamedNativeQuery(name = "Precio.searchPrecioActivoParaArticulo",
        query = "SELECT * FROM Precios WHERE Estatus_Activo = true AND id_articulo = ?1",
        resultClass = Precio.class)
public class Precio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double precio;

    @Column(name = "fecha_registro")

    private LocalDate fechaRegistro;

    @Column(name = "estatus_activo")
    private Boolean estatusActivo;

    @ManyToOne(targetEntity = Articulo.class)
    @JoinColumn(name = "id_Articulo")
    private Articulo articulo;

    public Precio() {
    }

    public Precio(Integer id, Double precio, LocalDate fechaRegistro, Boolean estatusActivo, Articulo articulo) {
        this.id = id;
        this.precio = precio;
        this.fechaRegistro = fechaRegistro;
        this.estatusActivo = estatusActivo;
        this.articulo = articulo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Boolean getEstatusActivo() {
        return estatusActivo;
    }

    public void setEstatusActivo(Boolean estatusActivo) {
        this.estatusActivo = estatusActivo;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    @Override
    public String toString() {
        return "Precio{" +
                "id=" + id +
                ", precio=" + precio +
                ", fechaRegistro=" + fechaRegistro +
                ", estatusActivo=" + estatusActivo +
                ", articulo=" + articulo +
                '}';
    }
}