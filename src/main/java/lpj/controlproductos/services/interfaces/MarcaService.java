package lpj.controlproductos.services.interfaces;

import lpj.controlproductos.model.Marca;

import java.util.List;

public interface MarcaService {

    public List<Marca> getAll();

    public Marca getMarcaById(Long idMarca);

    public Marca saveMarca(Marca marca);

    public void deleteMarca(Marca marca);

}
