package com.ryfsystems.Telcom.entity.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "facturaitems")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacturaItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int idfactura;
    private String descripcion;
    private float cantidad;
    private int idalmacen;
    private int unidades;
    private int impuesto;
    private int block;
    private float impuesto911;

}
