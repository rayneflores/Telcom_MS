package com.ryfsystems.Telcom.entity.dao;

import com.ryfsystems.Telcom.entity.models.TblAvisoUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITblAvisoUserDao extends CrudRepository<TblAvisoUser, Integer> {

    Optional<TblAvisoUser> findByCliente(int cliente);
}
