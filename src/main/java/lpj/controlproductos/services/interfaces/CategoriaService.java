package lpj.controlproductos.services.interfaces;

import lpj.controlproductos.model.Categoria;

import java.util.List;

public interface CategoriaService {

    public List<Categoria> getAll();
    public Categoria getCategoriaById(Long idCategoria);
    public Categoria saveCategoria(Categoria categoria);
    public void deleteCategoria(Categoria categoria);

}
