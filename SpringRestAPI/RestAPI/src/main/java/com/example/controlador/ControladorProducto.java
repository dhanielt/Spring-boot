
package com.example.controlador;

import com.example.entidades.Producto;
import com.example.servicios.ProductosRegistrados;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;




@RestController
@RequestMapping("/servicios")
public class ControladorProducto {

    @Autowired
    private ProductosRegistrados productosRegistrados;

    @GetMapping("/productos/{id}")
    public Producto buscarProducto(@PathVariable Integer id) {
        return this.productosRegistrados.buscarProducto(id);
    }

    @GetMapping("/productos/clientes/{id}")
    public List<Producto> buscarProductoPorCliente(@PathVariable Integer id) {

        return this.productosRegistrados.buscarProductoPorCliente(id);
    }

    @GetMapping("/productos")
    public List<Producto> productosRegistrados() {

        return productosRegistrados.listaProductosRegistrados();
    }

    @GetMapping("/misproductos")
    @ResponseBody
    public List<Producto> misProductosRegistrados() {

        return productosRegistrados.listaProductosRegistrados();
    }

    @PostMapping("/productos")
    public  Producto nuevoProducto(@RequestBody Producto producto) {

        this.productosRegistrados.ingresarProducto(producto);
        return producto;
    }

    @PutMapping("/productos/{id}")
    public  ResponseEntity<String> actualizarProducto(@RequestBody Producto producto, @PathVariable Integer id) {

        if (this.productosRegistrados.actualizarInformacionProducto(producto, id))
            return ResponseEntity.ok("Producto actualizado correctamente");
        else
            return ResponseEntity.ok("Producto no está registrado");

    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<String> removerProducto(@PathVariable Integer id) {
        if (this.productosRegistrados.eliminarInformacionProducto(id))
            return ResponseEntity.ok("Producto eliminado correctamente");
        else
            return ResponseEntity.ok("Producto no está registrado");
    }

}
