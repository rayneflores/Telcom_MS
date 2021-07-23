package com.ryfsystems.Telcom.services.impl;

import com.ryfsystems.Telcom.entity.dao.IPasarelaOtrosDao;
import com.ryfsystems.Telcom.entity.models.PasarelaOtro;
import com.ryfsystems.Telcom.services.IPasarelaOtrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PasarelaOtrosServiceImpl implements IPasarelaOtrosService {

    @Autowired
    IPasarelaOtrosDao pasarelaOtrosDao;

    @Override
    public Optional<PasarelaOtro> get(long id) {
        return pasarelaOtrosDao.findById(id);
    }

    @Override
    public Iterable<PasarelaOtro> getAll() {
        return pasarelaOtrosDao.findAll();
    }
}