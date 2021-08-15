package com.ryfsystems.Telcom.services.impl;

import com.ryfsystems.Telcom.entity.dao.ITblAvisoUserDao;
import com.ryfsystems.Telcom.entity.models.TblAvisoUser;
import com.ryfsystems.Telcom.services.ITblAvisoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class TblAvisoUserServiceImpl implements ITblAvisoUserService {

    @Autowired
    ITblAvisoUserDao tblAvisoUserDao;

    @Override
    public Optional<TblAvisoUser> getAvisoByCliente(int cliente) {
        Optional<TblAvisoUser> tblAvisoUser = tblAvisoUserDao.findByCliente(cliente);

        if (!tblAvisoUser.isPresent()) {
            return Optional.empty();
        }

        return tblAvisoUser;
    }
}
