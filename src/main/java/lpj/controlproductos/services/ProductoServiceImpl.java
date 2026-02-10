package lpj.controlproductos.services;

import lpj.controlproductos.model.Producto;
import lpj.controlproductos.repositories.ProductoRepository;
import lpj.controlproductos.services.interfaces.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    @Override
    public Producto getProductoById(Long idProducto) {
        return productoRepository.findById(idProducto).orElse(null);
    }

    @Override
    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    @Override
    @Transactional
    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    @Transactional
    public void deleteProducto(Producto producto) {
        productoRepository.delete(producto);
    }
}
