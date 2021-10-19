package com.ryfsystems.Telcom.controllers;

import com.ryfsystems.Telcom.entity.models.Servicio;
import com.ryfsystems.Telcom.services.IServicioService;
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
@RequestMapping("/api/servicio")
public class ServicioController {

    @Autowired
    IServicioService servicioService;

    @GetMapping("/")
    public Map<String, List<Servicio>> getAllServicios() {
        Map<String, List<Servicio>> response = new HashMap<>();
        List<Servicio> serviciosList;
        serviciosList = StreamSupport
                .stream(servicioService.getAll().spliterator(), false)
                .collect(Collectors.toList());
        response.put("servicios", serviciosList);

        return response;
    }

    @GetMapping("/withName/{name}")
    public Map<String, List<Servicio>> getAllServiciosWithName(@PathVariable("name") String name) {
        Map<String, List<Servicio>> response = new HashMap<>();
        List<Servicio> serviciosList;
        serviciosList = StreamSupport
                .stream(servicioService.findAllWithDescriptionQuery(name).spliterator(), false)
                .collect(Collectors.toList());
        response.put("servicios", serviciosList);
        return response;
    }

    @GetMapping("/withNameA/{cedula}")
    public Map<String, List<Servicio>> getAllServiciosWithName2(@PathVariable("cedula") String cedula) {
        Map<String, List<Servicio>> response = new HashMap<>();
        List<Servicio> serviciosList;
        serviciosList = StreamSupport
                .stream(servicioService.findAllWithDescriptionQuery2(cedula).spliterator(), false)
                .collect(Collectors.toList());
        response.put("servicios", serviciosList);
        return response;
    }
}
