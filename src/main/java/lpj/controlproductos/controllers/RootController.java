package lpj.controlproductos.controllers;

import lombok.extern.slf4j.Slf4j;
import lpj.controlproductos.model.Categoria;
import lpj.controlproductos.model.Marca;
import lpj.controlproductos.model.Negocio;
import lpj.controlproductos.model.Producto;
import lpj.controlproductos.services.interfaces.CategoriaService;
import lpj.controlproductos.services.interfaces.MarcaService;
import lpj.controlproductos.services.interfaces.NegocioService;
import lpj.controlproductos.services.interfaces.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.w3c.dom.ls.LSInput;

import java.util.List;

@Controller
@Slf4j
public class RootController {

    @Autowired
    ProductoService productoService;

    @Autowired
    CategoriaService categoriaService;

    @Autowired
    MarcaService marcaService;

    @Autowired
    NegocioService negocioService;

    @GetMapping("/")
    public String inicio(Model model) {

        List<Negocio> negocios = negocioService.listarNegocios();

        model.addAttribute("negocios",negocios);
//        log.info("NEGOCIOS DISPONIBLES: "+ negocios);
        return "layout/index";
    }



}
