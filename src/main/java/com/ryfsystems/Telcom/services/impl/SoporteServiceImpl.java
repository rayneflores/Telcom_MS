package com.ryfsystems.Telcom.services.impl;

import com.ryfsystems.Telcom.entity.dao.ISoporteDao;
import com.ryfsystems.Telcom.entity.models.Soporte;
import com.ryfsystems.Telcom.services.ISoporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class SoporteServiceImpl implements ISoporteService {

    @Autowired
    ISoporteDao soporteDao;

    @Override
    public Iterable<Soporte> findAllWithDescriptionQuery(String soportista) {
        return soporteDao.findAllWithDescriptionQuery(soportista);
    }

    @Override
    public Iterable<Soporte> findAllWithDescriptionQuery2(String cliente) {
        return soporteDao.findAllWithDescriptionQuery2(cliente);
    }

    @Override
    public Soporte update(Long id) throws Exception {
        try {
            Optional<Soporte> optionalSoporte = soporteDao.findById(id);
            if (!optionalSoporte.isPresent()){
                throw new Exception("Support Ticket Not Found");
            }

            Soporte obj = optionalSoporte.get();

            obj.setEstado("respondido");
            obj.setFechaSoporte(new Date());
            obj.setFechaCerrado(new Date());
            soporteDao.save(obj);
            return obj;

        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    @Override
    public Soporte close(Long id, String motivoCierre) throws Exception {
        try {
            Optional<Soporte> optionalSoporte = soporteDao.findById(id);
            if (!optionalSoporte.isPresent()){
                throw new Exception("Support Ticket Not Found");
            }

            Soporte obj = optionalSoporte.get();

            obj.setEstado("cerrado");
            obj.setFechaCerrado(new Date());
            obj.setMotivoCierre(motivoCierre);
            soporteDao.save(obj);
            return obj;

        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }
}
