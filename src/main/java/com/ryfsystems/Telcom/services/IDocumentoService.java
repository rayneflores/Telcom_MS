package com.ryfsystems.Telcom.services;

import com.ryfsystems.Telcom.entity.models.Documento;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface IDocumentoService {
    Optional<Documento> getByDocNum();

    ResponseEntity<?> updateDocumento();

}
