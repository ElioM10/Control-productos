package lpj.controlproductos.controllers;

import lombok.extern.slf4j.Slf4j;
import lpj.controlproductos.model.Categoria;
import lpj.controlproductos.model.Marca;
import lpj.controlproductos.model.Producto;
import lpj.controlproductos.services.interfaces.CategoriaService;
import lpj.controlproductos.services.interfaces.MarcaService;
import lpj.controlproductos.services.interfaces.ProductoService;
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
    ProductoService productoService;

    @Autowired
    CategoriaService categoriaService;

    @Autowired
    MarcaService marcaService;

    @GetMapping("/")
    public String inicio(Model model) {
        //Obtenemos todos los productos y las categorias
        List<Producto> productos = productoService.getProductos();
        Producto producto = new Producto();

        //las cargamos al modelo de la página
        model.addAttribute("productos",productos);
        model.addAttribute("producto",producto);
        return "layout/index";
    }

    @GetMapping("/admin/agregar")
    public String agregarProducto(Model model) {

        Producto producto = new Producto();
        List<Categoria> categorias = categoriaService.getAll();
        List<Marca> marcas  = marcaService.getAll();

        model.addAttribute("categorias",categorias);
        model.addAttribute("producto",producto);
        model.addAttribute("marcas",marcas);

        log.info("Se ha creado un producto vacío");
        log.info("Categorias cargadas: "+categorias.toString());
        log.info("Marcas cargadas: "+categorias.toString());

        return "producto/agregarProducto";
    }

    @PostMapping("/admin/guardar")
    public String guardar(Producto producto){
        productoService.save(producto);
        return "redirect:/";
    }

    @GetMapping("/admin/editar/{idProducto}")
    public String editar(Producto producto,Model model){
    producto = productoService.getProductoById(producto.getIdProducto());
    model.addAttribute("producto",producto);
    log.info("producto seleccionado: "+producto.toString());
    return "redirect:/";
    }

    @GetMapping("/admin/eliminar/{idProducto}")
    public String eliminar(Producto producto,Model model){
        producto = productoService.getProductoById(producto.getIdProducto());
        log.info("producto seleccionado: "+producto.toString());
        productoService.delete(producto);
        return "redirect:/";
    }
}
