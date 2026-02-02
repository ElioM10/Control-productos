package lpj.controlproductos.model;

import jakarta.persistence.*;
import org.springframework.web.servlet.view.DefaultRequestToViewNameTranslator;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String username;

    private String password;

    @OneToMany(mappedBy = "usuario",fetch = FetchType.LAZY)
    private Set<DetallesUsuario> detalles;


}
