package com.ryfsystems.Telcom.controllers;

import com.ryfsystems.Telcom.entity.models.FacturaItem;
import com.ryfsystems.Telcom.services.IFacturaItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/facturaItems")
public class FacturaItemController {

    @Autowired
    IFacturaItemsService facturaItemsService;

    @GetMapping("/allByFacturaId/{facturaId}")
    public Map<String, List<FacturaItem>> getAllItemsOfFactura(@PathVariable(value = "facturaId") int facturaId) {
        Map<String, List<FacturaItem>> response = new HashMap<>();
        List<FacturaItem> facturaItemsList;
        facturaItemsList = StreamSupport
                .stream(facturaItemsService.getAllByFacturaId(facturaId).spliterator(), false)
                .collect(Collectors.toList());
        response.put("items", facturaItemsList);
        return response;
    }

}