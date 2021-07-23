package com.ryfsystems.Telcom.controllers;

import com.ryfsystems.Telcom.entity.models.Zona;
import com.ryfsystems.Telcom.services.IZonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/zona")
public class ZonaController {

    @Autowired
    IZonaService zonaService;

    @GetMapping("/")
    public Map<String, List<Zona>> getAllZonas(){
        Map<String, List<Zona>> response = new HashMap<>();
        List<Zona> zonasList;
        zonasList = StreamSupport
                .stream(zonaService.getAllOrdered().spliterator(), false)
                .collect(Collectors.toList());
        response.put("zonas", zonasList);
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(value = "id") long id) {
        Optional<Zona> optionalZona = zonaService.getById(id);
        if (!optionalZona.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(optionalZona);
    }
}
