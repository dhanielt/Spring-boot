package com.example.repositorio;

import com.example.entidades.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductoRepositorio {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Producto buscarPorIdProducto(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM producto  where idProducto=?", new BeanPropertyRowMapper<>(Producto.class), id);
    }
    public List<Producto> buscarPorIdCliente(Integer id) {
        return jdbcTemplate.query("SELECT * FROM producto  where idCliente=?", new ProductoRowMapper(), id);
    }
    public List<Producto> buscarTodos() {
        return jdbcTemplate.query("select * from producto", new ProductoRowMapper());
    }

    public List<Producto> buscarTodosV2() {
        return jdbcTemplate.query("select * from producto", new  BeanPropertyRowMapper<>(Producto.class));
    }

    public int eliminarPorId(long id) {

        return jdbcTemplate.update("delete from producto where idProducto=?", id);
    }

    public int insertar(Producto producto) {

        return jdbcTemplate.update("insert into producto (idProducto, nombre, precio) " + "values(?, ?, ?, ?)",
                producto.getIdProducto(), producto.getNombre(), producto.getPrecio());
    }

    public int actualizar(Producto producto) {

        return jdbcTemplate.update("update producto " + " nombre = ?, precio = ? " + " where idProducto = ?",
                producto.getNombre(), producto.getPrecio(),producto.getIdProducto());
    }

}
