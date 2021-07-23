package com.ryfsystems.Telcom.services.impl;

import com.ryfsystems.Telcom.entity.dao.IFacturaItemDao;
import com.ryfsystems.Telcom.entity.models.FacturaItem;
import com.ryfsystems.Telcom.services.IFacturaItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaItemServiceImpl implements IFacturaItemsService {

    @Autowired
    IFacturaItemDao facturaItemDao;

    @Override
    public Iterable<FacturaItem> getAllByFacturaId(int facturaId) {
        return facturaItemDao.getAllByIdfactura(facturaId);
    }
}