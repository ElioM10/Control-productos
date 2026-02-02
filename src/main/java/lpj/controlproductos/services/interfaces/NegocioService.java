package lpj.controlproductos.services.interfaces;

import lpj.controlproductos.model.Negocio;

import java.util.List;

public interface NegocioService {

    public List<Negocio> listarNegocios();

    public Negocio getNegocioById(Long idNegocio);

    public Negocio saveNegocio(Negocio negocio);

    public void deleteNegocio(Negocio negocio);


}
