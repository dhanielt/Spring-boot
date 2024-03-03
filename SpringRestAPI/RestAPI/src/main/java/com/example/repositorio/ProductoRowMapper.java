
package com.example.repositorio;



import com.example.entidades.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.entidades.Producto;
import org.springframework.jdbc.core.RowMapper;


public  class ProductoRowMapper implements RowMapper<Producto>  {

    @Override
    public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {

        Producto producto = new Producto();
        producto.setIdProducto(Integer.valueOf(rs.getString("idProducto")));
        producto.setNombre(rs.getString("nombre"));
        producto.setPrecio(Integer.valueOf(rs.getString("precio")));
        return producto;
    }

}
