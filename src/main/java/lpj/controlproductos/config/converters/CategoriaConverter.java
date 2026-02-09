package lpj.controlproductos.config.converters;

import lpj.controlproductos.model.Categoria;
import lpj.controlproductos.services.interfaces.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoriaConverter implements Converter<String,Categoria> {

    @Autowired
    CategoriaService categoriaService;

    @Override
    public Categoria convert(String id) {
        return categoriaService.getCategoriaById(Long.valueOf(id));
    }

}
