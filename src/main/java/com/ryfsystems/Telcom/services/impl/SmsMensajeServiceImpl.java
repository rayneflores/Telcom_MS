package com.ryfsystems.Telcom.services.impl;

import com.ryfsystems.Telcom.entity.dao.ISmsMensajeDao;
import com.ryfsystems.Telcom.entity.models.SmsMensaje;
import com.ryfsystems.Telcom.services.ISmsMensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmsMensajeServiceImpl implements ISmsMensajeService {

    @Autowired
    ISmsMensajeDao smsMensajeDao;

    @Override
    public SmsMensaje create(SmsMensaje smsMensaje) {
        SmsMensaje newSmsMensaje = smsMensajeDao.save(smsMensaje);
        return newSmsMensaje;
    }
}
