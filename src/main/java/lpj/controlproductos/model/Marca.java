package lpj.controlproductos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @OneToMany(mappedBy = "marcaProducto")
    List<Producto> productos;
}
