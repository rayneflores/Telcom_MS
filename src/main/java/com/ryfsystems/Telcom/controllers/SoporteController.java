package com.ryfsystems.Telcom.controllers;

import com.ryfsystems.Telcom.entity.models.Soporte;
import com.ryfsystems.Telcom.services.ISoporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/soporte")
public class SoporteController {

    @Autowired
    ISoporteService soporteService;

    @GetMapping("/openBySoportista/{soportista}")
    public Map<String, List<Soporte>> getAllSoporteOpenBySoportista(@PathVariable(value = "soportista") String soportista) {
        Map<String, List<Soporte>> response = new HashMap<>();
        List<Soporte> soporteList;
        soporteList = StreamSupport
                .stream(soporteService.findAllWithDescriptionQuery(soportista.trim()).spliterator(), false)
                .collect(Collectors.toList());
        response.put("soporte", soporteList);
        return response;
    }

    @GetMapping("/allByClient/{clientName}")
    public Map<String, List<Soporte>> getAllSoporteByClient(@PathVariable(value = "clientName") String cliente) {
        Map<String, List<Soporte>> response = new HashMap<>();
        List<Soporte> soporteList;
        soporteList = StreamSupport
                .stream(soporteService.findAllWithDescriptionQuery2(cliente).spliterator(), false)
                .collect(Collectors.toList());
        response.put("soporte", soporteList);
        return response;
    }

    @PutMapping("/update/{id}")
    public Soporte update(@PathVariable(value = "id") Long id) throws Exception {
        return soporteService.update(id);
    }

    @PutMapping("/close/{id}/{motivoCierre}")
    public Soporte close(@PathVariable(value = "id") Long id,
                         @PathVariable(value = "motivoCierre") String motivoCierre) throws Exception {
        return soporteService.close(id, motivoCierre);
    }
}
