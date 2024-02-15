
package com.example.servicios;

import com.example.entidades.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientesRegistrados {
    
    private final  ArrayList<Cliente> listadoClientes;
    private Cliente cliente;
    
    public ClientesRegistrados( @Autowired Cliente cliente) {
        this.listadoClientes = new ArrayList<>();
        this.cliente=cliente;
        this.cliente.setIdCliente(100);
        this.cliente.setRazonSocial("Unillanos");
        this.cliente.setEmail("email@unillanos.edu.co");
        this.listadoClientes.add(cliente);
    }
    public void ingresarCliente(Cliente cliente){
        
        this.listadoClientes.add(cliente);
    }
    public Cliente buscarCliente(Integer id){
        
        
        Cliente cliente=new Cliente();
        
        for( Cliente c : listadoClientes)        {
           
            if (Objects.equals(c.getIdCliente(), id))
            {
                cliente=c;                
                break;
            }
                
        }        
        return cliente;
    }    
    public List listaClientesRegistrados(){
        
        return this.listadoClientes;
    }
    public Boolean actualizarInformacionCliente(Cliente cliente,Integer id){
        int index=0;
        Boolean estado=false;
        for(Cliente c : listadoClientes)
           {
               if (Objects.equals(c.getIdCliente(), id))
               {
                   this.listadoClientes.set(index, cliente);
                   estado=true;
                   break;
               }                       
               index++;
           }       
        return estado;
    }
    public Boolean eliminarInformacionCliente(Integer id){
        int index=0;
        Boolean estado=false;
        for(Cliente c : listadoClientes)
           {
               if (Objects.equals(c.getIdCliente(), id))
               {
                   this.listadoClientes.remove(index);
                   estado=true;
                   break;
               }                       
               index++;
           }       
        
        return estado;
    }
}
