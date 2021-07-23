package com.ryfsystems.Telcom.entity.dao;

import com.ryfsystems.Telcom.entity.models.Zona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IZonaDao extends CrudRepository<Zona, Long> {

    Iterable<Zona> findAllByOrderByZonaAsc();

}