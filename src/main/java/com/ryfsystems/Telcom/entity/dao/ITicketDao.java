package com.ryfsystems.Telcom.entity.dao;

import com.ryfsystems.Telcom.entity.models.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITicketDao extends CrudRepository<Ticket, Long> {

    Iterable<Ticket> findAllByIdticketOrderByIdDesc(int idticket);
}
