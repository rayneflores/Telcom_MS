package com.ryfsystems.Telcom.controllers;

import com.ryfsystems.Telcom.entity.models.Soporte;
import com.ryfsystems.Telcom.entity.models.Ticket;
import com.ryfsystems.Telcom.services.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @Autowired
    ITicketService ticketService;

    @GetMapping("/ticketBySoporte/{idTicket}")
    public Map<String, List<Ticket>> allTicketBySoporte(@PathVariable(value = "idTicket") int idTicket) {
        Map<String, List<Ticket>> response = new HashMap<>();
        List<Ticket> ticketList;
        ticketList = StreamSupport
                .stream(ticketService.findAllByIdTicket(idTicket).spliterator(), false)
                .collect(Collectors.toList());
        response.put("tickets", ticketList);
        return response;
    }

    @PostMapping()
    public ResponseEntity<?> createTicket(@RequestBody Ticket ticket) {

        try {
            return ResponseEntity.ok(ticketService.create(ticket));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }
}
