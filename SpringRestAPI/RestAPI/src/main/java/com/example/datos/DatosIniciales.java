
package com.example.datos;

import com.example.entidades.Cliente;
import com.example.servicios.ClientesRegistrados;
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
    
    @Bean
    CommandLineRunner initDatabase() {

    return args -> {
        
      Cliente cliente= new Cliente();
      cliente.setIdCliente(200);
      cliente.setRazonSocial("SENA");
      cliente.setEmail("email@sena.edu.co");
      clientesRegistrados.ingresarCliente(cliente);
      
      logCadena.info("Cargando datos iniciales " + cliente.toString()  );
      
      cliente= new Cliente();
      cliente.setIdCliente(300);
      cliente.setRazonSocial("empresa-sas");
      cliente.setEmail("email@empresa-sas.co");      
      clientesRegistrados.ingresarCliente(cliente);
      
      logCadena.info("CArgando datos iniciales " + cliente.toString()  );
    };
  }    
}
