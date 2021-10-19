package com.ryfsystems.Telcom.services;

import com.ryfsystems.Telcom.entity.models.Servicio;

public interface IServicioService {

    Iterable<Servicio> getAll();
    Iterable<Servicio> findAllWithDescriptionQuery(String name);
    Iterable<Servicio> findAllWithDescriptionQuery2(String cedula);
}
