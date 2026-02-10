package lpj.controlproductos.services;

import lpj.controlproductos.model.Categoria;
import lpj.controlproductos.repositories.CategoriaRepository;
import lpj.controlproductos.services.interfaces.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CategoriaServiceImpl implements CategoriaService, Converter<String,Categoria> {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> getCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria getCategoriaById(Long idCategoria) {
        return categoriaRepository.findById(idCategoria).orElse(null);
    }

    @Override
    @Transactional
    public Categoria saveCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    @Transactional
    public void deleteCategoria(Categoria categoria) {
        categoriaRepository.delete(categoria);
    }

    @Override
    public Categoria convert(String idCategoria) {
        return categoriaRepository.findById(Long.valueOf(idCategoria)).orElse(null);
    }
}
