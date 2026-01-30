package lpj.controlproductos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "producto")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    private String nombreProducto;

    private String descripcion;

    private Double precioProducto;

    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoriaProducto;

    @ManyToOne
    @JoinColumn(name = "id_marca")
    private Marca marcaProducto;

    public Double getTotal(){
        if(precioProducto == null || cantidad == null){
            return 0.0;
        }else {
            return precioProducto * cantidad;
        }
    }
}
