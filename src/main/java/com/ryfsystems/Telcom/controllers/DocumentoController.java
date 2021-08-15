package com.ryfsystems.Telcom.controllers;

import com.ryfsystems.Telcom.entity.models.Documento;
import com.ryfsystems.Telcom.services.IDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/documento")
public class DocumentoController {

    @Autowired
    IDocumentoService documentoService;

    @GetMapping("/")
    public Map<String, Documento> getbyDocNum() {

        Map<String, Documento> response = new HashMap<>();

        Optional<Documento> optionalDocumento = documentoService.getByDocNum();

        if (!optionalDocumento.isPresent()) {
            return null;
        }

        Documento documento = new Documento();
        documento.setN(optionalDocumento.get().getN());
        documento.setDocnum(optionalDocumento.get().getDocnum());
        documento.setEmirtn(optionalDocumento.get().getEmirtn());
        documento.setEmiema(optionalDocumento.get().getEmiema());
        documento.setEmicai(optionalDocumento.get().getEmicai());
        documento.setEmicae(optionalDocumento.get().getEmicae());
        documento.setFecini(optionalDocumento.get().getFecini());
        documento.setFecfin(optionalDocumento.get().getFecfin());
        documento.setVinini(optionalDocumento.get().getVinini());
        documento.setVinfin(optionalDocumento.get().getVinfin());
        documento.setNumini(optionalDocumento.get().getNumini());
        documento.setNumfin(optionalDocumento.get().getNumfin());
        documento.setFaccod(optionalDocumento.get().getFaccod());
        documento.setDoctip(optionalDocumento.get().getDoctip());
        documento.setFaccom(optionalDocumento.get().getFaccom());
        documento.setDocact(optionalDocumento.get().getDocact());

        response.put("documento", documento);

        return response;
    }

    @PutMapping("/")
    public ResponseEntity<?> updateDocument() {
        Optional<Documento> documento = documentoService.getByDocNum();

        if (!documento.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok().body(documentoService.updateDocumento());
    }
}
