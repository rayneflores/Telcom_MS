package com.ryfsystems.Telcom.controllers;

import com.ryfsystems.Telcom.entity.models.PasarelaOtro;
import com.ryfsystems.Telcom.services.IPasarelaOtrosService;
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
@RequestMapping("/api/pasarela")
public class PasarelaOtrosController {

    @Autowired
    IPasarelaOtrosService pasarelaOtrosService;

    @GetMapping("/")
    public Map<String, List<PasarelaOtro>> getAll() {
        Map<String, List<PasarelaOtro>> response = new HashMap<>();
        List<PasarelaOtro> pasarelaOtroList;
        pasarelaOtroList = StreamSupport
                .stream(pasarelaOtrosService.getAll().spliterator(), false)
                .collect(Collectors.toList());
        response.put("pasarelas", pasarelaOtroList);
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") long id) {
        Optional<PasarelaOtro> optionalPasarela = pasarelaOtrosService.get(id);
        if (!optionalPasarela.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(optionalPasarela);
    }
}