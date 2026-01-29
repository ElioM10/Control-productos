package lpj.controlproductos.repositories;

import lpj.controlproductos.model.Producto;
import lpj.controlproductos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
