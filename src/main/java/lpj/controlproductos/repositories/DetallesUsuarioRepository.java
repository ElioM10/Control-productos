package lpj.controlproductos.repositories;

import lpj.controlproductos.model.DetallesUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallesUsuarioRepository extends JpaRepository<DetallesUsuario,Long> {
}
