
package com.example.repositorio;



import com.example.entidades.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;


public  class ClienteRowMapper   implements RowMapper<Cliente>  {

    @Override
    public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {

        Cliente cliente=new Cliente();
        cliente.setIdCliente(Integer.valueOf(rs.getString("idCliente")));
        cliente.setRazonSocial(rs.getString("razonSocial"));
        cliente.setEmail(rs.getString("email"));
        return cliente;
    }

}