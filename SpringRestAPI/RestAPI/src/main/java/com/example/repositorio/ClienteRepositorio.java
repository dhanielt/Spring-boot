package com.example.repositorio;

import ch.qos.logback.core.net.server.Client;
import com.example.entidades.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepositorio {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Cliente buscarPorId(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM cliente  where idCliente=?", new BeanPropertyRowMapper<>(Cliente.class), id);
    }
    public List<Cliente> buscarTodos() {
        return jdbcTemplate.query("select * from cliente", new ClienteRowMapper());
    }

    public List<Cliente> buscarTodosV2() {
        return jdbcTemplate.query("select * from cliente", new  BeanPropertyRowMapper<>(Cliente.class));
    }

    public int eliminarPorId(long id) {
        int valor;

        valor = jdbcTemplate.update("delete from cliente where idCliente=?", id);
        return valor;
    }

    public int insertar(Cliente cliente) {
        return jdbcTemplate.update("insert into cliente (idCliente, razonSocial, email) " + "values(?,  ?, ?)",
                cliente.getIdCliente(), cliente.getRazonSocial(), cliente.getEmail());
    }

    public int actualizar(Cliente cliente) {
        int valor;
        valor = jdbcTemplate.update("update cliente " + " set razonSocial = ?, email = ? " + " where idCliente = ?",
                cliente.getRazonSocial(), cliente.getEmail(), cliente.getIdCliente());
        return valor;
    }

}