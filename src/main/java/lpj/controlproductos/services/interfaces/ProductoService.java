package lpj.controlproductos.services.interfaces;

import lpj.controlproductos.model.Producto;

import java.util.List;

public interface ProductoService{

    public Producto getProductoById(Long idProducto);
    public List<Producto> getProductos();
    public Producto save(Producto producto);
    public void delete(Producto producto);
}
