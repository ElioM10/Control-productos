package lpj.controlproductos.controllers;

import lombok.extern.slf4j.Slf4j;
import lpj.controlproductos.model.Negocio;
import lpj.controlproductos.services.interfaces.CategoriaService;
import lpj.controlproductos.services.interfaces.MarcaService;
import lpj.controlproductos.services.interfaces.NegocioService;
import lpj.controlproductos.services.interfaces.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
public class RootController {

    @Autowired
    NegocioService negocioService;

    @GetMapping("/")
    public String inicio(Model model) {

        List<Negocio> negocios = negocioService.listarNegocios();

        model.addAttribute("negocios",negocios);

        return "layout/index";
    }

    @GetMapping("/login")
    public String login(){
        return "login/login";
    }

}
