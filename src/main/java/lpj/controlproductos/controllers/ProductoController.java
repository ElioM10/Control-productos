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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
public class ProductoController {

    @Autowired
    NegocioService negocioService;

    @Autowired
    CategoriaService categoriaService;

    @Autowired
    MarcaService marcaService;

    @Autowired
    ProductoService productoService;

    @GetMapping("/admin/producto/agregar/{idNegocio}")
    public String agregarProducto(@PathVariable Long idNegocio,Model model,Producto producto) {

        List<Categoria> categorias = categoriaService.getCategorias();
        List<Marca> marcas  = marcaService.getMarcas();

        model.addAttribute("categorias",categorias);
        model.addAttribute("producto",producto);
        model.addAttribute("marcas",marcas);

        log.info("Se ha creado un producto vacío");

        return "producto/agregarProducto";
    }

    @GetMapping("/user/negocio/{idNegocio}")
    public String listarProductos(@PathVariable Long idNegocio, Model model){

        Negocio negocio = negocioService.getNegocioById(idNegocio);

        List<Producto> productos = productoService.getProductos();
        model.addAttribute("productos",productos);
        model.addAttribute("idNegocio",idNegocio);

        return "producto/listaProductos";
    }

    @PostMapping("/admin/producto/guardar")
    public String guardar(@RequestParam Long idNegocio,
            @RequestParam Long idMarca,
            @RequestParam Long idCategoria,
            Producto producto){
        Negocio negocio = negocioService.getNegocioById(idNegocio);
        Categoria categoria = categoriaService.getCategoriaById(idCategoria);
        Marca marca = marcaService.getMarcaById(idMarca);

        producto.setNegocio(negocio);
        producto.setCategoriaProducto(categoria);
        producto.setMarcaProducto(marca);

        productoService.saveProducto(producto);
        return "redirect:/user/negocio/"+producto.getNegocio().getIdNegocio();
    }

}
