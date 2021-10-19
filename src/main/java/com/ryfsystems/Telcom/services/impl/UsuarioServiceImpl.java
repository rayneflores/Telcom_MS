package com.ryfsystems.Telcom.services.impl;

import com.ryfsystems.Telcom.entity.dao.IUsuarioDao;
import com.ryfsystems.Telcom.entity.models.Usuario;
import com.ryfsystems.Telcom.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    IUsuarioDao usuarioDao;

    @Override
    public Optional<Usuario> get(long id) {
        return usuarioDao.findById(id);
    }

    @Override
    public Iterable<Usuario> getAll() {
        return usuarioDao.findAll();
    }

    @Override
    public Iterable<Usuario> getByZonaUsuarios(String zona) {
        return usuarioDao.getByClienteZona(zona);
    }

    @Override
    public Optional<Usuario> getByCedulaAndPassActivos(String cedula, String pass, String estado) {
        return usuarioDao.findByCedulaAndCodigoAndEstado(cedula, pass, estado);
    }
}