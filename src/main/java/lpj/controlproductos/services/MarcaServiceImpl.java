package lpj.controlproductos.services;

import lpj.controlproductos.model.Marca;
import lpj.controlproductos.repositories.MarcaRepository;
import lpj.controlproductos.services.interfaces.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
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
    @Transactional
    public Marca saveMarca(Marca marca) {
        return marcaRepository.save(marca);
    }

    @Override
    @Transactional
    public void deleteMarca(Marca marca) {
        marcaRepository.delete(marca);
    }
}
