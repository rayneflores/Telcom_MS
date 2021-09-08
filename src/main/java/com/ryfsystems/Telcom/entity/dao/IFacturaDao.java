package com.ryfsystems.Telcom.entity.dao;

import com.ryfsystems.Telcom.entity.models.Factura;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IFacturaDao extends CrudRepository<Factura, Long> {

    Iterable<Factura> getAllByIdcliente(int idCliente);
    Iterable<Factura> getAllByEstado(String estado);
    Iterable<Factura> findAllByIdclienteAndEstado(int idCliente, String estado);
    Iterable<Factura> findAllByIdclienteInAndEstado(List<Integer> clientslist, String estado);

    @Query("Select " +
            "f.id, " +
            "u.nombre, f.emitido, f.legal, f.total, f.vencimiento, f.pago, u.direccionPrincipal, u.telefono, u.movil, u.correo, u.id, u.facturacionTipo, u.cedula " +
            "from Factura f " +
            "left join Usuario u " +
            "on f.idcliente = u.id " +
            "where f.estado = 'No Pagado' and u.clienteZona = :zona")
    Iterable<Factura> findAllWithDescriptionQuery(@Param("zona") String zona);

    @Query("Select " +
            "f.id, " +
            "u.nombre, f.emitido, f.legal, f.total, f.vencimiento, f.pago, u.direccionPrincipal, u.telefono, u.movil, u.correo, u.id, u.facturacionTipo, u.cedula " +
            "from Factura f " +
            "left join Usuario u " +
            "on f.idcliente = u.id " +
            "where f.estado = 'No Pagado' and u.nombre like %:nombre%")
    Iterable<Factura> findAllByClientWithDescriptionQuery(@Param("nombre") String nombre);

    @Query("Select " +
            "f.id, " +
            "u.nombre, f.emitido, f.legal, f.total, f.vencimiento, f.pago, u.direccionPrincipal, u.telefono, u.movil, u.correo, u.id, u.facturacionTipo, u.cedula " +
            "from Factura f " +
            "left join Usuario u " +
            "on f.idcliente = u.id " +
            "where f.estado = 'pagado' and u.nombre like %:nombre% order by f.id desc")
    Iterable<Factura> findAllByClientWithDescriptionQuery2(@Param("nombre") String nombre);

    @Query("Select " +
            "f.id, " +
            "u.nombre," +
            "f.cobrado " +
            "from Factura f " +
            "left join Usuario u " +
            "on f.idcliente = u.id " +
            "where f.forma like :forma% and f.pago = :pago order by f.id desc")
    Iterable<Factura> findAllWithDescriptionQuery2(@Param("forma") String forma, @Param("pago") Date pago);
}