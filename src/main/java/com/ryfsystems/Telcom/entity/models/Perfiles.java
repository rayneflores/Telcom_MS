package com.ryfsystems.Telcom.entity.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "perfiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Perfiles implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String plan;
    private String descripcion;
    private String velocidad;
    private String pcq;
    private String prioridad;
    private float costo;
    private String profile;
    private String lista;
    private int limitat;
    private int burstLimit;
    private int burstThreshold;
    private int burstTime;
    private float impuesto;
    private int api;
    private String idMikrotik;
    private String limitDown;
    private String limitUp;
    private String parent;
    private int isDisabled;
    private int reuso;
}
