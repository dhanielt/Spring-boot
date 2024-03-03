
package com.example.servicios;

import com.example.entidades.Producto;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.example.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductosRegistrados {

    private final ProductoRepositorio productoRepositorio;

    Producto producto;

    @Autowired
    public ProductosRegistrados(ProductoRepositorio productoRepositorio, Producto  producto) {
        this.productoRepositorio = productoRepositorio;
        this.producto = producto;
        this.producto.setIdProducto(1);
        this.producto.setIdCliente(100);
        this.producto.setNombre("edicacion");
        this.producto.setPrecio(125000);
        this.productoRepositorio.insertar(this.producto);
    }
    public void ingresarProducto(Producto producto){

        this.productoRepositorio.insertar(producto);
    }
    public Producto buscarProducto(Integer id){

        return this.productoRepositorio.buscarPorIdProducto(id);
    }

    public List<Producto> buscarProductoPorCliente(Integer id){

        return this.productoRepositorio.buscarPorIdCliente(id);
    }

    public List listaProductosRegistrados(){

        return this.productoRepositorio.buscarTodos();
    }
    public Boolean actualizarInformacionProducto(Producto producto,Integer id){

        if(this.productoRepositorio.actualizar(producto) > 0) return true;
        else return false;
    }
    public Boolean eliminarInformacionProducto(Integer id){

        if(this.productoRepositorio.eliminarPorId(id) > 0) return true;
        else return false;
    }
}
