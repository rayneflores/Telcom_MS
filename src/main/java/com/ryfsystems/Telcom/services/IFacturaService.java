package com.ryfsystems.Telcom.services;

import com.ryfsystems.Telcom.entity.models.Factura;

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
    void updateStatus(long id, String forma);
}
