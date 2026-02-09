package lpj.controlproductos.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "producto")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    private String nombreProducto;

    private String descripcion;

    private BigDecimal precioProducto;

    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "id_negocio")
    private Negocio negocio;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoriaProducto;


    @ManyToOne
    @JoinColumn(name = "id_marca")
    private Marca marcaProducto;

    public BigDecimal getTotal(){
        if(precioProducto == null || cantidad == null){
            return BigDecimal.valueOf(0);
        }else {
            return precioProducto.multiply(BigDecimal.valueOf(cantidad));
        }
    }
}
