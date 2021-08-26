package com.ryfsystems.Telcom.controllers;

import com.ryfsystems.Telcom.entity.models.SmsMensaje;
import com.ryfsystems.Telcom.services.ISmsMensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/smsmensaje")
public class SmsMensajeController {

    @Autowired
    ISmsMensajeService smsMensajeService;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody SmsMensaje smsMensaje) {

        try {
            return ResponseEntity.ok(smsMensajeService.create(smsMensaje));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }

    }

}
