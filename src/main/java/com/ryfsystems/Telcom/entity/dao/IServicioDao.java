package com.ryfsystems.Telcom.entity.dao;

import com.ryfsystems.Telcom.entity.models.Servicio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IServicioDao extends CrudRepository<Servicio, Long> {

    @Query("Select " +
            "u.id, u.nombre, " +
            "s.descripcion " +
    "from Servicio s " +
    "left join Usuario u " +
    "on s.idcliente = u.id " +
    "where u.estado = 'SUSPENDIDO' and u.nombre like %:nombre%")
    Iterable<Servicio> findAllWithDescriptionQuery(@Param("nombre") String nombre);
}
