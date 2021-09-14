package com.ryfsystems.Telcom.services.impl;

import com.ryfsystems.Telcom.entity.dao.ITicketDao;
import com.ryfsystems.Telcom.entity.models.Ticket;
import com.ryfsystems.Telcom.services.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements ITicketService {

    @Autowired
    ITicketDao ticketDao;

    @Override
    public Iterable<Ticket> findAllByIdTicket(int idTicket) {
        return ticketDao.findAllByIdticketOrderByIdDesc(idTicket);
    }

    @Override
    public Ticket create(Ticket ticket) {
        Ticket newTicket = ticketDao.save(ticket);
        return newTicket;
    }
}
