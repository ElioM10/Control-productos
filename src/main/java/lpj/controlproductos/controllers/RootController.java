package lpj.controlproductos.controllers;

import lombok.extern.slf4j.Slf4j;
import lpj.controlproductos.model.Producto;
import lpj.controlproductos.repositories.ProductoRepository;
import lpj.controlproductos.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
public class RootController {

    @Autowired
    ProductoService productoService;

    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("producto", new Producto());

        List<Producto> productos = productoService.getProductos();

        model.addAttribute("productos",productos);
        return "layout/index";
    }

    @PostMapping("/admin/agregar")
    public String agregarProducto(@ModelAttribute("producto") Producto producto) {
        log.info("Producto agregado: {}", producto);
        productoService.save(producto);
        return "redirect:/";
    }
}
