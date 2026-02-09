package lpj.controlproductos.controllers;

import lpj.controlproductos.model.Negocio;
import lpj.controlproductos.services.interfaces.NegocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NegocioController {

    @Autowired
    NegocioService negocioService;

    @PostMapping("/admin/negocio/guardar")
    public String guardar(Negocio negocio){
        negocioService.saveNegocio(negocio);
        return "redirect:/";
    }

    @GetMapping("/admin/negocio/agregar")
    public String agregar(Model model){
        model.addAttribute("negocio",new Negocio());
        return "negocio/agregarNegocio";
    }

}
