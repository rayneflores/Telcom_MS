package com.ryfsystems.Telcom.services;

import com.ryfsystems.Telcom.entity.models.FacturaItem;

public interface IFacturaItemsService {

    Iterable<FacturaItem> getAllByFacturaId(int facturaId);
}
