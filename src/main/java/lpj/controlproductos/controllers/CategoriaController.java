package lpj.controlproductos.controllers;

import lombok.extern.slf4j.Slf4j;
import lpj.controlproductos.model.Categoria;
import lpj.controlproductos.services.interfaces.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @PostMapping("/admin/categoria/guardar")
    public String guardarCategoria(@RequestParam Long idNegocio,
                                   @RequestParam String nombreCategoria){

        Categoria categoria = new Categoria();
        categoria.setNombreCategoria(nombreCategoria);
        categoriaService.saveCategoria(categoria);
        log.info("Se ha creado una nueva categoría");

        return "redirect:/admin/producto/agregar/"+idNegocio;
    }

}
