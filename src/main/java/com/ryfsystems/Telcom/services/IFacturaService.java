package com.ryfsystems.Telcom.services;

import com.ryfsystems.Telcom.entity.models.Factura;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IFacturaService {

    Optional<Factura> get(long id);
    Iterable<Factura> getAllByClientId(int clientId);
    Iterable<Factura> getAllByEstado(String estado);
    Iterable<Factura> getAllByClientIdAndEstado(int idCliente, String estado);
    Iterable<Factura> getAllByClientIdsAndEstado(List<Integer> clientIdList, String estado);
    Iterable<Factura> getAll();
    Iterable<Factura> findAllWithDescriptionQuery(String zona);
    Iterable<Factura> findAllByClientWithDescriptionQuery(String name);
    Iterable<Factura> findAllByClientWithDescriptionQuery2(String name);
    Iterable<Factura> findAllWithDescriptionQuery2(String forma, Date pago);
    Iterable<Factura> findAllWithDescriptionQuery3(Date pago);
    void updateStatus(long id, String forma);
}
