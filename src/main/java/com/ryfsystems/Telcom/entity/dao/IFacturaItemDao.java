package com.ryfsystems.Telcom.entity.dao;

import com.ryfsystems.Telcom.entity.models.FacturaItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacturaItemDao extends CrudRepository<FacturaItem, Long> {

    Iterable<FacturaItem> getAllByIdfactura(int idFactura);

}