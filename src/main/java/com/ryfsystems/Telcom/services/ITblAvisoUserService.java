package com.ryfsystems.Telcom.services;

import com.ryfsystems.Telcom.entity.models.TblAvisoUser;

import java.util.Optional;

public interface ITblAvisoUserService {

    Optional<TblAvisoUser> getAvisoByCliente(int cliente);
}
