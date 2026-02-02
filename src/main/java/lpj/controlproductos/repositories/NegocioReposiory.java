package lpj.controlproductos.repositories;

import lpj.controlproductos.model.Negocio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NegocioReposiory extends JpaRepository<Negocio,Long> {
}
