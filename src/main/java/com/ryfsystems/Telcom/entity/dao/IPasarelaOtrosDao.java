package com.ryfsystems.Telcom.entity.dao;

import com.ryfsystems.Telcom.entity.models.PasarelaOtro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPasarelaOtrosDao extends CrudRepository<PasarelaOtro, Long> {
}