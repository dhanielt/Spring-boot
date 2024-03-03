
package com.example.datos;

import com.example.entidades.Cliente;
import com.example.entidades.Producto;
import com.example.servicios.ClientesRegistrados;
import com.example.servicios.ProductosRegistrados;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatosIniciales {
    
    private static Logger logCadena= LoggerFactory.getLogger(DatosIniciales.class);
    
    @Autowired
    private ClientesRegistrados clientesRegistrados;
    @Autowired
    private ProductosRegistrados productosRegistrados;
    
    @Bean
    CommandLineRunner initDatabase() {

    return args -> {
        
      Cliente cliente= new Cliente();
      cliente.setIdCliente(200);
      cliente.setRazonSocial("SENA");
      cliente.setEmail("email@sena.edu.co");
      clientesRegistrados.ingresarCliente(cliente);

      Producto servicio = new Producto();
      servicio.setIdProducto(2);
      servicio.setIdCliente(cliente.getIdCliente());
      servicio.setNombre("educacion");
      servicio.setPrecio(50000);
      productosRegistrados.ingresarProducto(servicio);

      logCadena.info("Cargando datos iniciales " + cliente.toString() + " servicio que presta " + servicio.toString() );
      
      cliente= new Cliente();
      cliente.setIdCliente(300);
      cliente.setRazonSocial("empresa-sas");
      cliente.setEmail("email@empresa-sas.co");      
      clientesRegistrados.ingresarCliente(cliente);

      servicio = new Producto();
      servicio.setIdProducto(3);
      servicio.setIdCliente(cliente.getIdCliente());
      servicio.setNombre("acciones");
      servicio.setPrecio(500000000);
      productosRegistrados.ingresarProducto(servicio);
      
      logCadena.info("Cargando datos iniciales " + cliente.toString() + " servicio que presta " + servicio.toString() );
      logCadena.info("realizado por Luisa María Ramos Velásquez 160004927 y Dhanielt Felipe Rubio Prasca 160004935" );
    };
  }    
}
