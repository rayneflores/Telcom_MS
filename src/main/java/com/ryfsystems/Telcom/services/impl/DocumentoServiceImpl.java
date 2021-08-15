package com.ryfsystems.Telcom.services.impl;

import com.ryfsystems.Telcom.entity.dao.IDocumentoDao;
import com.ryfsystems.Telcom.entity.models.Documento;
import com.ryfsystems.Telcom.services.IDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class DocumentoServiceImpl implements IDocumentoService {

    @Autowired
    IDocumentoDao documentoDao;

    @Override
    public Optional<Documento> getByDocNum() {

        Optional<Documento> documento = documentoDao.findByDocnum("1");

        if (!documento.isPresent()) {
            return Optional.empty();
        }

        return documento;
    }

    @Override
    public ResponseEntity<?> updateDocumento() {

        Optional<Documento> documento = documentoDao.findByDocnum("1");
        if (!documento.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        Documento newDocumento = new Documento();
        newDocumento.setN(documento.get().getN());
        newDocumento.setDocnum(documento.get().getDocnum());
        newDocumento.setEmirtn(documento.get().getEmirtn());
        newDocumento.setEmiema(documento.get().getEmiema());
        newDocumento.setEmicai(documento.get().getEmicai());
        newDocumento.setEmicae(documento.get().getEmicae());
        newDocumento.setFecini(documento.get().getFecini());
        newDocumento.setFecfin(documento.get().getFecfin());
        newDocumento.setVinini(documento.get().getVinini());
        newDocumento.setVinfin(documento.get().getVinfin());
        newDocumento.setNumini(documento.get().getNumini());
        newDocumento.setNumfin(documento.get().getNumfin());
        newDocumento.setFaccod(documento.get().getFaccod() + 1);
        newDocumento.setDoctip(documento.get().getDoctip());
        newDocumento.setFaccom(documento.get().getFaccom());
        newDocumento.setDocact(documento.get().getDocact());

        documentoDao.save(newDocumento);

        return ResponseEntity.ok().build();
    }
}
