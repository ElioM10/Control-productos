package lpj.controlproductos.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuraio;

    private String username;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Rol> roles;

}
