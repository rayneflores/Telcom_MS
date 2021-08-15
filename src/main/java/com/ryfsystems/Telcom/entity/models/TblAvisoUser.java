package com.ryfsystems.Telcom.entity.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tblavisouser")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TblAvisoUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int cliente;
    private String mora;
    private String reconexion;
    private String impuesto;
    private long avatar_cliente;
    private int chat;
    private int zona;
    private int diapago;
    private int tipopago;
    private int tipoaviso;
    private int meses;
    private Date fecha_factura;
    private int diafactura;
    private int avisopantalla;
    private int corteautomatico;
    private int avisosms;
    private int avisosms2;
    private int avisosms3;
    private String afip_condicion_iva;
    private String afip;
    private String afip_condicion_venta;
    private int afip_automatico;
    private String avatar_color;
    private int tiporecordatorio;
    private String afip_punto_venta;
    private int id_telegram;
    private int router_eliminado;
    private String otros_impuestos;
    private String mikrowisp_app_id;
    private int isaviable;
    private int invoice_electronic;
    private String invoice_data;
    private Date fecha_suspendido;
    private int limit_velocidad;
    private int mantenimiento;
    private String data_retirado;
    private Date fecha_retirado;
    private int tipo_estrato;
    private Date fecha_corte_fija;
    private int mensaje_comprobante;
    private int id_moneda;
    private float afip_enable_percepcion;
}
