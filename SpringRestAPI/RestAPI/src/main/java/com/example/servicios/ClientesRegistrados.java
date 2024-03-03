
package com.example.servicios;

import com.example.entidades.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.example.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientesRegistrados {

    private final ClienteRepositorio clienteRepositorio;

    Cliente cliente;

    @Autowired
    public ClientesRegistrados(ClienteRepositorio clienteRepositorio, Cliente  cliente) {
        this.clienteRepositorio = clienteRepositorio;
        this.cliente = cliente;
        this.cliente.setIdCliente(100);
        this.cliente.setRazonSocial("unillanos");
        this.cliente.setEmail("email@unillanos.edu.co");
        this.clienteRepositorio.insertar(this.cliente);
    }
    public void ingresarCliente(Cliente cliente){

        this.clienteRepositorio.insertar(cliente);
    }
    public Cliente buscarCliente(Integer id){
        
        return this.clienteRepositorio.buscarPorId(id);
    }    
    public List listaClientesRegistrados(){

        return this.clienteRepositorio.buscarTodos();
    }
    public Boolean actualizarInformacionCliente(Cliente cliente,Integer id){

        if(this.clienteRepositorio.actualizar(cliente) > 0) return true;
        else return false;
    }
    public Boolean eliminarInformacionCliente(Integer id){

        if(this.clienteRepositorio.eliminarPorId(id) > 0) return true;
        else return false;
    }
}
