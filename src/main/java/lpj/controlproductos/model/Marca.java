package lpj.controlproductos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "marca")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMarca;

    private String nombreMarca;

    @OneToMany(mappedBy = "marcaProducto")
    List<Producto> productos;
}
