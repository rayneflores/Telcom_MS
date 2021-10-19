package com.ryfsystems.Telcom.services.impl;

import com.ryfsystems.Telcom.entity.dao.IFacturaDao;
import com.ryfsystems.Telcom.entity.models.Factura;
import com.ryfsystems.Telcom.services.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FacturaServiceImpl implements IFacturaService {

    @Autowired
    IFacturaDao facturaDao;

    @Override
    public Optional<Factura> get(long id) {
        return facturaDao.findById(id);
    }

    @Override
    public Iterable<Factura> getAllByClientId(int clientId) {
        return facturaDao.getAllByIdcliente(clientId);
    }

    @Override
    public Iterable<Factura> getAllByEstado(String estado) {
        return facturaDao.getAllByEstado(estado);
    }

    @Override
    public Iterable<Factura> getAllByClientIdAndEstado(int idCliente, String estado) {
        return facturaDao.findAllByIdclienteAndEstado(idCliente, "No Pagado");
    }

    @Override
    public Iterable<Factura> getAllByClientIdsAndEstado(List<Integer> clientIdList, String estado) {
        return facturaDao.findAllByIdclienteInAndEstado(clientIdList, "No Pagado");
    }

    @Override
    public Iterable<Factura> getAll() {
        return facturaDao.findAll();
    }

    @Override
    public Iterable<Factura> findAllWithDescriptionQuery(String zona) {
        return facturaDao.findAllWithDescriptionQuery(zona);
    }

    @Override
    public Iterable<Factura> findAllByClientWithDescriptionQuery(String name) {
        return facturaDao.findAllByClientWithDescriptionQuery(name);
    }

    @Override
    public Iterable<Factura> findAllByClientWithDescriptionQuery2(String name) {
        return facturaDao.findAllByClientWithDescriptionQuery2(name);
    }

    @Override
    public Iterable<Factura> findAllWithDescriptionQuery2(String forma, Date pago) {
        return facturaDao.findAllWithDescriptionQuery2(forma, pago);
    }

    @Override
    public Iterable<Factura> findAllWithDescriptionQuery3(Date pago) {
        return facturaDao.findAllWithDescriptionQuery3(pago);
    }

    @Override
    public void updateStatus(long id, String forma) {
        facturaDao.findById(id).ifPresent(x -> {
            x.setEstado("pagado");
            x.setPago(new Date());
            x.setForma(forma);
            facturaDao.save(x);
        });
    }
}