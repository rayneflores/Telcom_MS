package com.ryfsystems.Telcom.services;

import com.ryfsystems.Telcom.entity.models.Soporte;

public interface ISoporteService {

    Iterable<Soporte> findAllWithDescriptionQuery(String soportista);
    Iterable<Soporte> findAllWithDescriptionQuery2(String cliente);
    Soporte update(Long id) throws Exception;
    Soporte close(Long id, String motivoCierre) throws Exception;
}
