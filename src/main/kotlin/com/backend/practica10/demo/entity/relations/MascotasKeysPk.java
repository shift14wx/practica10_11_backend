package com.backend.practica10.demo.entity.relations;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

public class MascotasKeysPk implements Serializable{
    public MascotasKeysPk() {
    }
    @Column(name = "codigo_cliente")
    private Long codigo_cliente;
    @Column(name = "codigo_especie")
    private Long codigo_especie;

    public MascotasKeysPk(Long codigo_cliente, Long codigo_especie) {
        this.codigo_cliente = codigo_cliente;
        this.codigo_especie = codigo_especie;
    }

    public Long getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(Long codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public Long getCodigo_especie() {
        return codigo_especie;
    }

    public void setCodigo_especie(Long codigo_especie) {
        this.codigo_especie = codigo_especie;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}