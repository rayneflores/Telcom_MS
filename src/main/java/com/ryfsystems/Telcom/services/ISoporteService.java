package com.ryfsystems.Telcom.services;

import com.ryfsystems.Telcom.entity.models.Soporte;

import java.util.Optional;

public interface ISoporteService {

    Iterable<Soporte> findAllWithDescriptionQuery(String soportista);
    Soporte update(Long id) throws Exception;
    Soporte close(Long id) throws Exception;
}
