package lpj.controlproductos.services;

import lpj.controlproductos.model.DetallesUsuario;
import lpj.controlproductos.repositories.DetallesUsuarioRepository;
import lpj.controlproductos.services.interfaces.DetallesUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallesUsuarioServiceImpl implements DetallesUsuarioService {

    @Autowired
    DetallesUsuarioRepository detallesUsuarioRepository;

    @Override
    public List<DetallesUsuario> getDetallesUsuario() {
        return detallesUsuarioRepository.findAll();
    }

    @Override
    public DetallesUsuario getDetallesUsuarioById(Long id) {
        return detallesUsuarioRepository.findById(id).orElse(null);
    }

    @Override
    public DetallesUsuario saveDetallesUsuario(DetallesUsuario detallesUsuario) {
        return detallesUsuarioRepository.save(detallesUsuario);
    }

    @Override
    public void deleteDetallesUsuario(DetallesUsuario detallesUsuario) {
        detallesUsuarioRepository.delete(detallesUsuario);
    }
}
