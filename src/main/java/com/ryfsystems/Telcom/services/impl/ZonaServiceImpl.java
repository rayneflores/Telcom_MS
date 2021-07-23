package com.ryfsystems.Telcom.services.impl;

import com.ryfsystems.Telcom.entity.dao.IZonaDao;
import com.ryfsystems.Telcom.entity.models.Zona;
import com.ryfsystems.Telcom.services.IZonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ZonaServiceImpl implements IZonaService {

    @Autowired
    IZonaDao zonaDao;

    @Override
    public Optional<Zona> getById(long id) {
        return zonaDao.findById(id);
    }

    @Override
    public Iterable<Zona> getAllOrdered() {
        return zonaDao.findAllByOrderByZonaAsc();
    }
}
