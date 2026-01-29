package lpj.controlproductos.services;

import lpj.controlproductos.model.Producto;
import lpj.controlproductos.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    ProductoRepository productoRepository;

    @Override
    @Transactional(readOnly = true)
    public Producto getProductoById(Long idProducto) {
        return productoRepository.findById(idProducto).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    @Override
    @Transactional
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoRepository.delete(producto);
    }
}
