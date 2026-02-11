package lpj.controlproductos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.DefaultRequestToViewNameTranslator;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "usuario")
@Data
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @NotEmpty(message = "Debe ingresar un nombre de usuario")
    private String username;

    @NotEmpty(message = "Debe ingresar una contrasena")
    private String password;

    @OneToMany(mappedBy = "usuario",fetch = FetchType.LAZY)
    private Set<DetallesUsuario> detalles;


}
