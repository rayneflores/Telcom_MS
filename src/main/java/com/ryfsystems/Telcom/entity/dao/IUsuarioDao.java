package com.ryfsystems.Telcom.entity.dao;

import com.ryfsystems.Telcom.entity.models.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

    Iterable<Usuario> getByClienteZona(String zona);
    Optional<Usuario> findByCedulaAndCodigoAndEstado(String cedula, String codigo, String estado);
}