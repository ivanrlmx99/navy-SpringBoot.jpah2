package com.ivan.mx.navy.jpa.app.models.dao;

import com.ivan.mx.navy.jpa.app.models.entity.Cliente;

import java.util.List;

public interface IClienteDao {
    public List<Cliente> findAll();
}
