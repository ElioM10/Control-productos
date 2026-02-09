package lpj.controlproductos.controllers;

import lombok.extern.slf4j.Slf4j;
import lpj.controlproductos.model.Marca;
import lpj.controlproductos.services.interfaces.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
public class MarcaController {

    @Autowired
    MarcaService marcaService;

    @PostMapping("/admin/marca/guardar")
    public String guardar(@RequestParam String nombreMarca,
                          @RequestParam Long idNegocio
    ){
        Marca marca = new Marca();
        marca.setNombreMarca(nombreMarca);
        marcaService.saveMarca(marca);
        log.info("Se ha creado una nueva marca");
        return "redirect:/admin/producto/agregar/"+idNegocio;
    }

}
