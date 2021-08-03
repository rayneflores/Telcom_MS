package com.ryfsystems.Telcom.controllers;

import com.ryfsystems.Telcom.entity.models.Factura;
import com.ryfsystems.Telcom.services.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/factura")
public class FacturaController {

    @Autowired
    IFacturaService facturaService;

    @GetMapping("/")
    public Map<String, List<Factura>> getAllFacturas() {
        Map<String, List<Factura>> response = new HashMap<>();
        List<Factura> facturasList;
        facturasList = StreamSupport
                .stream(facturaService.getAll().spliterator(), false)
                .collect(Collectors.toList());
        response.put("facturas", facturasList);
        return response;
    }

    @GetMapping("/withName/{zona}")
    public Map<String, List<Factura>> getAllFacturasWithName(@PathVariable(value = "zona") String zona) {
        Map<String, List<Factura>> response = new HashMap<>();
        List<Factura> facturasList;
        facturasList = StreamSupport
                .stream(facturaService.findAllWithDescriptionQuery(zona).spliterator(), false)
                .collect(Collectors.toList());
        response.put("facturas", facturasList);
        return response;
    }

    @GetMapping("/withClientName/{name}")
    public Map<String, List<Factura>> getAllFacturasWithClientName(@PathVariable(value = "name") String name) {
        Map<String, List<Factura>> response = new HashMap<>();
        List<Factura> facturasList;
        facturasList = StreamSupport
                .stream(facturaService.findAllByClientWithDescriptionQuery(name).spliterator(), false)
                .collect(Collectors.toList());
        response.put("facturas", facturasList);
        return response;
    }

    @GetMapping("/allByClientId/{clientId}")
    public Map<String, List<Factura>> getAllClientIdFacturas(@PathVariable(value = "clientId") int clientId) {
        Map<String, List<Factura>> response = new HashMap<>();
        List<Factura> facturasList;
        facturasList = StreamSupport
                .stream(facturaService.getAllByClientId(clientId).spliterator(), false)
                .collect(Collectors.toList());
        response.put("facturas", facturasList);
        return response;
    }

    @GetMapping("/allByEstado/{estado}")
    public Map<String, List<Factura>> getAllEstadoFact(@PathVariable(value = "estado") String estado) {
        Map<String, List<Factura>> response = new HashMap<>();
        List<Factura> facturasList;
        facturasList = StreamSupport
                .stream(facturaService.getAllByEstado(estado).spliterator(), false)
                .collect(Collectors.toList());
        response.put("facturas", facturasList);
        return response;
    }

    @PostMapping("/allByClientsList/{clientIds}")
    public Map<String, List<Factura>> getAllClientFacturas(@RequestBody ArrayList<Integer> clientIds) {
        Map<String, List<Factura>> response = new HashMap<>();
        List<Factura> facturasList;
        facturasList = StreamSupport
                .stream(facturaService.getAllByClientIdsAndEstado(clientIds, null).spliterator(), false)
                .collect(Collectors.toList());
        response.put("facturas", facturasList);
        return response;
    }

    @GetMapping("/allByClientIdPendientes/{clientId}")
    public Map<String, List<Factura>> getAllFacturasPendientesByClientId(@PathVariable(value = "clientId") int clientId) {
        Map<String, List<Factura>> response = new HashMap<>();
        List<Factura> facturasList;
        facturasList = StreamSupport
                .stream(facturaService.getAllByClientIdAndEstado(clientId, null).spliterator(), false)
                .collect(Collectors.toList());
        response.put("facturas", facturasList);
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(value = "id") long id) {
        Optional<Factura> optionalFactura = facturaService.get(id);
        if (!optionalFactura.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Factura factura = new Factura();
        factura.setId(optionalFactura.get().getId());
        factura.setIdcliente(optionalFactura.get().getIdcliente());
        factura.setForma(optionalFactura.get().getForma());
        factura.setPago(optionalFactura.get().getPago());
        factura.setEstado(optionalFactura.get().getEstado());
        factura.setCobrado(optionalFactura.get().getCobrado());
        factura.setEmitido(optionalFactura.get().getEmitido());
        return ResponseEntity.ok(factura);
    }

    @PutMapping("/changeStatus/{id}/{forma}")
    public ResponseEntity<?> updateById(@PathVariable(value = "id") long id,
                                        @RequestParam(value = "forma") String forma) {
        Optional<Factura> optionalFactura = facturaService.get(id);
        if (!optionalFactura.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        facturaService.updateStatus(id, forma);
        return ResponseEntity.ok("Factura: " + id + " Actualizada");
    }
}
