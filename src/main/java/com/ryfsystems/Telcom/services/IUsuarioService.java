package com.ryfsystems.Telcom.services;

import com.ryfsystems.Telcom.entity.models.Usuario;

import java.util.Optional;

public interface IUsuarioService {

    Optional<Usuario> get(long id);
    Iterable<Usuario> getAll();
    Iterable<Usuario> getByZonaUsuarios(String zona);
    Optional<Usuario> getByCedulaAndPassActivos(String cedula, String pass, String estado);
}