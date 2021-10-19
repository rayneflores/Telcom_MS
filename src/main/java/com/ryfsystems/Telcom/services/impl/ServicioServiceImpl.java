package com.ryfsystems.Telcom.services.impl;

import com.ryfsystems.Telcom.entity.dao.IServicioDao;
import com.ryfsystems.Telcom.entity.models.Servicio;
import com.ryfsystems.Telcom.services.IServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioServiceImpl implements IServicioService {

    @Autowired
    IServicioDao servicioDao;

    @Override
    public Iterable<Servicio> getAll() {
        return servicioDao.findAll();
    }

    @Override
    public Iterable<Servicio> findAllWithDescriptionQuery(String name) {
        return servicioDao.findAllWithDescriptionQuery(name);
    }

    @Override
    public Iterable<Servicio> findAllWithDescriptionQuery2(String cedula) {
        return servicioDao.findAllWithDescriptionQuery2(cedula);
    }
}
