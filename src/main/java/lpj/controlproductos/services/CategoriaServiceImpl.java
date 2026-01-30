package lpj.controlproductos.services;

import lpj.controlproductos.model.Categoria;
import lpj.controlproductos.repositories.CategoriaRepository;
import lpj.controlproductos.services.interfaces.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService, Converter<String,Categoria> {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> getAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria getCategoriaById(Long idCategoria) {
        return categoriaRepository.findById(idCategoria).orElse(null);
    }

    @Override
    public Categoria saveCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public void deleteCategoria(Categoria categoria) {
        categoriaRepository.delete(categoria);
    }

    @Override
    public Categoria convert(String idCategroia) {
        return categoriaRepository.findById(Long.valueOf(idCategroia)).orElse(null);
    }
}
