package com.ryfsystems.Telcom.entity.dao;

import com.ryfsystems.Telcom.entity.models.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

    Iterable<Usuario> getByClienteZona(String zona);
}