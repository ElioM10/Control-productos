package lpj.controlproductos.services;

import lpj.controlproductos.model.Marca;
import lpj.controlproductos.repositories.MarcaRepository;
import lpj.controlproductos.services.interfaces.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaServiceImpl implements MarcaService {

    @Autowired
    MarcaRepository marcaRepository;

    @Override
    public List<Marca> getMarcas() {
        return marcaRepository.findAll();
    }

    @Override
    public Marca getMarcaById(Long idMarca) {
        return marcaRepository.findById(idMarca).orElse(null);
    }

    @Override
    public Marca saveMarca(Marca marca) {
        return marcaRepository.save(marca);
    }

    @Override
    public void deleteMarca(Marca marca) {
        marcaRepository.delete(marca);
    }
}
