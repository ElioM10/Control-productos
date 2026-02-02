package lpj.controlproductos.services.interfaces;

import lpj.controlproductos.model.Producto;

import java.util.List;

public interface ProductoService{

    public Producto getProductoById(Long idProducto);
    public List<Producto> getProductos();
    public Producto saveProducto(Producto producto);
    public void deleteProducto(Producto producto);
}
