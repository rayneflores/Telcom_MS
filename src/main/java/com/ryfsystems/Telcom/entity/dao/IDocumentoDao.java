package com.ryfsystems.Telcom.entity.dao;

import com.ryfsystems.Telcom.entity.models.Documento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDocumentoDao extends CrudRepository<Documento, Long> {

    Optional<Documento> findByDocnum(String docnum);

}
