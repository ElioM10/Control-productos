package lpj.controlproductos.services;

import lpj.controlproductos.model.Negocio;
import lpj.controlproductos.repositories.NegocioReposiory;
import lpj.controlproductos.services.interfaces.NegocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class NegocioServiceImpl implements NegocioService {

    @Autowired
    NegocioReposiory negocioReposiory;

    @Override
    public List<Negocio> listarNegocios() {
        return negocioReposiory.findAll();
    }

    @Override
    public Negocio getNegocioById(Long idNegocio) {
        return negocioReposiory.findById(idNegocio).orElse(null);
    }

    @Override
    @Transactional
    public Negocio saveNegocio(Negocio negocio) {
        return negocioReposiory.save(negocio);
    }

    @Override
    @Transactional
    public void deleteNegocio(Negocio negocio) {
        negocioReposiory.delete(negocio);
    }
}
