
package com.example.entidades;
import org.springframework.stereotype.Component;

@Component
public class Cliente {

    private Integer idCliente;
    private String razonSocial;
    private String email;


    public Cliente() {
         this.idCliente = 0;
        this.razonSocial = "--";
        this.email = "--";
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", razonSocial=" + razonSocial + ", email=" + email + '}';
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
