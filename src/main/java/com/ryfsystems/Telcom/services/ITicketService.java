package com.ryfsystems.Telcom.services;

import com.ryfsystems.Telcom.entity.models.Ticket;

public interface ITicketService {

    Iterable<Ticket> findAllByIdTicket(int idTicket);
    Ticket create(Ticket ticket);
}
