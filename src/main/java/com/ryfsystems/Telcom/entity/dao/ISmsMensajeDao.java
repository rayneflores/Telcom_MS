package com.ryfsystems.Telcom.entity.dao;

import com.ryfsystems.Telcom.entity.models.SmsMensaje;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISmsMensajeDao extends CrudRepository<SmsMensaje, Long> {

}
