
package com.example.entidades;
import org.springframework.stereotype.Component;

@Component
public class Producto {

    private Integer idProducto;
    private Integer idCliente;
    private String nombre;
    private Integer precio;


    public Producto() {
        this.idCliente = 0;
        this.idProducto = 0;
        this.nombre = "--";
        this.precio = 0;
    }

    @Override
    public String toString() {
        return "Producto{" + "idCliente=" + idCliente + ", idProducto=" + idProducto + ", nombre=" + nombre + ", precio=" + precio + '}';
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
}
