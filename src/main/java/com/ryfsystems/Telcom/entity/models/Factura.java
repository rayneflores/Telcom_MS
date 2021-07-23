package com.ryfsystems.Telcom.entity.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "facturas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Factura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int legal;
    private int idcliente;
    private Date emitido;
    private Date vencimiento;
    private Date pago;
    private float total;
    private String forma;
    private String estado;
    private int tipo;
    private float cobrado;
    private float ivaIgv;
    private float subTotal;
    private String impuesto;
    private String mpId;
    private String mpEstado;
    private String payuId;
    private String payuPdf;
    private String payuUrlpdf;
    private String oxxoId;
    private String oxxoReferencia;
    private float totalKhipu;
    private String idKhipu;
    private String urlKhipu;
    private String barcodeCobroDigital;
    private String dataCobroDigital;

    @OneToMany(targetEntity = Usuario.class, mappedBy = "id", orphanRemoval = false, fetch = FetchType.LAZY)
    private Set<Usuario> usuarios;
}