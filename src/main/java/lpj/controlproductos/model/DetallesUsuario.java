package lpj.controlproductos.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table
public class DetallesUsuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetallesUsuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_negocio")
    private Negocio negocio;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;

    private LocalDate fechaAlta;
}
