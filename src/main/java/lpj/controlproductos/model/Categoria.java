package lpj.controlproductos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;

    @Column(name = "categoria")
    private String nombreCategoria;

    @OneToMany(mappedBy = "categoriaProducto")
    private List<Producto> productos;
}
