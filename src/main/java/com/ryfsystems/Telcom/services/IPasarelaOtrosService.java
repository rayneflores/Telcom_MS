package com.ryfsystems.Telcom.services;

import com.ryfsystems.Telcom.entity.models.PasarelaOtro;

import java.util.Optional;

public interface IPasarelaOtrosService {
    Optional<PasarelaOtro> get(long id);
    Iterable<PasarelaOtro> getAll();
}