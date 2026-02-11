package lpj.controlproductos.controllers;

import lombok.extern.slf4j.Slf4j;
import lpj.controlproductos.model.Negocio;
import lpj.controlproductos.model.Usuario;
import lpj.controlproductos.repositories.UsuarioRepository;
import lpj.controlproductos.services.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
public class RootController {

    @Autowired
    NegocioService negocioService;

    @Autowired
    UsuarioService usuarioService;

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

    @GetMapping("/register")
    public String mostrarForm(Model model){
        model.addAttribute("usuario",new Usuario());
        return "login/register";
    }

    @PostMapping("/register")
    public String guardarUsuario(Usuario usuario){
        log.info("Se ha creado un nuevo usuario");
        usuarioService.saveUsuario(usuario);
        return "redirect:/login";
    }

}
