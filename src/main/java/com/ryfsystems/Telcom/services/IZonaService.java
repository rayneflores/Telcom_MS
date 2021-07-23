package com.ryfsystems.Telcom.services;

import com.ryfsystems.Telcom.entity.models.Zona;

import java.util.Optional;

public interface IZonaService {
    Optional<Zona> getById(long id);
    Iterable<Zona> getAllOrdered();
}
