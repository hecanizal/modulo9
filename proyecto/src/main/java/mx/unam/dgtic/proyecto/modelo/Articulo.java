package mx.unam.dgtic.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "articulos")
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descripcion;

    private String codigo;

    private String clave;

    private String unidad;

    private Integer existencia;

    @Column(name = "codigo_barras")
    private String codigoBarras;

    @ManyToOne(targetEntity = Marca.class)
    @JoinColumn(name = "id_Marca")
    private Marca marca;

    @ManyToOne(targetEntity = Familia.class)
    @JoinColumn(name = "id_Familia")
    private Familia familia;

    public Articulo() {
    }

    public Articulo(Integer id, String descripcion, String codigo, String clave, String unidad, Integer existencia, String codigoBarras, Marca marca, Familia familia) {
        this.id = id;
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.clave = clave;
        this.unidad = unidad;
        this.existencia = existencia;
        this.codigoBarras = codigoBarras;
        this.marca = marca;
        this.familia = familia;
    }

    public Articulo(String descripcion, String codigo, String clave, String unidad, Marca marca, Familia familia) {
        this.id = 0;
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.clave = clave;
        this.unidad = unidad;
        this.existencia = 0;
        this.codigoBarras = null;
        this.marca = marca;
        this.familia = familia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public Integer getExistencia() {
        return existencia;
    }

    public void setExistencia(Integer existencia) {
        this.existencia = existencia;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", codigo='" + codigo + '\'' +
                ", clave='" + clave + '\'' +
                ", unidad='" + unidad + '\'' +
                ", existencia=" + existencia +
                ", codigoBarras='" + codigoBarras + '\'' +
                ", marca=" + marca +
                ", familia=" + familia +
                '}';
    }
}