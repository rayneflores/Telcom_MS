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
            "where u.estado = 'SUSPENDIDO' and u.nombre like %:nombre%"
    )
    Iterable<Servicio> findAllWithDescriptionQuery(@Param("nombre") String nombre);

    @Query("Select " +
            "u.nombre, u.facturacionTipo, " +
            "p.plan, p.velocidad, " +
            "s.costo, " +
            "a.diapago " +
            "from Usuario u " +
            "left join Servicio s on s.idcliente = u.id " +
            "left join Perfiles p on p.id = s.idperfil " +
            "left join TblAvisoUser a on a.cliente = u.id " +
            "where u.estado = 'ACTIVO' and u.cedula = :cedula"
    )
    Iterable<Servicio> findAllWithDescriptionQuery2(@Param("cedula") String cedula);
}
