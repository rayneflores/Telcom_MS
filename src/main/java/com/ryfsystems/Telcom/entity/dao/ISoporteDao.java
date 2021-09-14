package com.ryfsystems.Telcom.entity.dao;

import com.ryfsystems.Telcom.entity.models.Soporte;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISoporteDao extends CrudRepository<Soporte, Long> {

    @Query("select " +
           "s.id, s.fechaSoporte, l.nombre, u.nombre, s.asunto, s.operador, s.estado, s.idsoporte " +
           "from Soporte s " +
           "left join Login l " +
           "on l.id = s.idsoporte " +
           "left join Usuario u " +
           "on s.idcliente = u.id " +
           "where (s.estado = 'abierto' or s.estado = 'respondido') and l.nombre = :soportista order by s.estado asc ")
    Iterable<Soporte> findAllWithDescriptionQuery(String soportista);
}
