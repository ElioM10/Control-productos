package lpj.controlproductos.services.interfaces;

import lpj.controlproductos.model.DetallesUsuario;

import java.util.List;

public interface DetallesUsuarioService {

    public List<DetallesUsuario> getDetallesUsuario();

    public DetallesUsuario getDetallesUsuarioById(Long id);

    public DetallesUsuario saveDetallesUsuario(DetallesUsuario detallesUsuario);

    public void deleteDetallesUsuario(DetallesUsuario detallesUsuario);

}
