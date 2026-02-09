package lpj.controlproductos.config.converters;

import lpj.controlproductos.model.Marca;
import lpj.controlproductos.services.interfaces.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MarcaConverter implements Converter<String, Marca> {

    @Autowired
    MarcaService marcaService;

    @Override
    public Marca convert(String id) {
        return marcaService.getMarcaById(Long.valueOf(id));
    }
}
